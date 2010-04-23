/*
 * Created on Jan 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Category;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.server.SearchQuery;
import org.realtor.rets.server.decoder.Expression;
import org.realtor.rets.server.decoder.LookupNameDecoder;
import org.realtor.rets.util.ResourceLocator;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SqlQueryEngine implements QueryEngine {

    protected static Category cat = Category.getInstance(SqlQueryEngine.class);

    protected String sqlString = "";
    protected DataSource ds = null;

    /**
     * Intialize SqlQueryEngine
     * @param sqlSelect
     */
    public void init(String sqlSelect) {
        sqlString = sqlSelect;

        Context ctx;
        try {
            ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/rets");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            cat.error(e);
        }

    }

    /**
     * Execute a search against a sql database and return results.
     * @param query
     * @param parameters
     * @param decode True to decode lookup values, false otherwise.
     *
     * @see org.realtor.rets.persistence.QueryEngine#execute(org.realtor.rets.server.SearchQuery, java.util.Map)
     */
    public SearchResults execute(SearchQuery query, Map parameters, boolean decode) throws PersistenceException {

        String limitClause = this.createLimitClause(parameters);
        String whereClause = this.createWhereClause(query);
        SearchResults results = new SearchResults();
        List columnNames = new ArrayList();

        String queryString = sqlString + whereClause + limitClause;
        cat.debug("executing SQLQuery:"+queryString);


        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = ds.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryString);
            ResultSetMetaData rsmd = resultSet.getMetaData();

        	// some databases' ResultSetMetaData.getTableName(int) return an empty String
        	// tableName = "p";
            String tableName = rsmd.getTableName(1);

            int colCnt = rsmd.getColumnCount();
            List rows = new ArrayList();
            while (resultSet.next()) {
                List values = new ArrayList();
                HashMap listHash = new HashMap();
                for (int i = 1; i <= colCnt; i++) {
                	String columnName = rsmd.getColumnLabel(i).toLowerCase();
                	String value = StringEscapeUtils.escapeXml(resultSet.getString(i));

                	if (decode) {
                    	// decode the value based on MetaData LookupName values
                	    value = LookupNameDecoder.decodeSystemValue(columnName, value);
                	}

                    // for COMPACT
                    values.add(value);

                    // for XML
                    listHash.put(tableName + "." + columnName, value);
                }
                listHash.put("VALUES", values);
                rows.add(listHash);
            }

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(tableName + "." + rsmd.getColumnName(i));
            }
            results.setColumnNames(columnNames);
            results.setRows(rows);
        } catch (SQLException e) {
            cat.debug("Error performing search request.", e);
        } finally {
            // Clean up after ourselves
            if (resultSet != null) {
                try {resultSet.close();} catch (SQLException e) {
                    cat.error("Error closing resultSet for search.", e);
                }
            }
            if (statement != null) {
                try {statement.close();} catch (SQLException e) {
                    cat.error("Error closing statement for search.", e);
                }
            }
            if (conn != null) {
                try {conn.close();} catch (SQLException e) {
                    cat.error("Error closing connection for search.", e);
                }
            }
        }

        return results;
    }

    /**
     * @param retsParameters
     * @return
     */
    protected String createLimitClause(Map retsParameters) {

        //return ""; // not handling limit
    	// certain databases do not support LIMIT clause
        return createMySqlLimitClause(retsParameters);
    }
    protected String createMySqlLimitClause(Map retsParameters) {
        String limitClause;
        String searchOffset = (String) retsParameters.get(SEARCHOFFSET);
        String offset = "0";
        if (searchOffset != null) {
            try {
                offset = new Integer(searchOffset).toString();
            } catch (NumberFormatException nfe) {
                // default to 0
                offset = "0";
            }
        }
        String cntStr = (String) retsParameters.get(SEARCHLIMIT);
        String countLimit = "700";
        if (cntStr != null) {
            if (!"None".equalsIgnoreCase(cntStr)) {
                try {
                    countLimit = new Integer(cntStr).toString();
                } catch (NumberFormatException nfe) {
                    // default to 0
                    countLimit = "700";
                }
            }
        }

        limitClause = " limit " + offset + "," + countLimit;
        return limitClause;
    }

    /**
     * @param query
     * @return
     */
    protected String createWhereClause(SearchQuery query) {
        StringBuffer whereClause = new StringBuffer(" where ");
        Expression criteria = query.getQueryExpression();

        whereClause.append(this.evaluateExpression(criteria));

        return whereClause.toString();
    }

    /**
     * @param criteria
     * @param whereClause
     */
    protected String evaluateExpression(Expression criteria) {
        String operator = criteria.getOperator();
        List operands = criteria.getOperands();
        int operandCount = operands.size();
        Iterator operandIterator = operands.iterator();
        Object firstOperand = operandIterator.next();
        StringBuffer whereClause = new StringBuffer("(");
        String operandString = "";

        if (firstOperand instanceof String) {
            operandString = this.convertName((String) firstOperand);
        } else {
            operandString = this.writeOperand(firstOperand);
        }


        if (operator.equals("AND")) {
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    whereClause.append(operandString);
                    Object operand = operandIterator.next();
                    whereClause.append(" AND ");
                    whereClause.append(this.writeOperand(operand));
                }
            }
        } else  if (operator.equals("OR")) {
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    whereClause.append(operandString);
                    Object operand = operandIterator.next();
                    whereClause.append(" OR ");
                    whereClause.append(this.writeOperand(operand));
                }
            }
        } else  if (operator.equals("NOR")) {
            whereClause.append(" NOT (");
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    whereClause.append(operandString);
                    Object operand = operandIterator.next();
                    whereClause.append(" OR ");
                    whereClause.append(this.writeOperand(operand));
                }
            }
            whereClause.append(")");
        } else  if (operator.equals("MATCHES")) {
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    whereClause.append("UPPER(" + operandString + ")");
                    Object operand = operandIterator.next();
                    whereClause.append(" LIKE ");
                    if (operand instanceof String) {
                        //String likeClause = "'%" + escapeSQLQuotes(operand.toString()) + "%'";
                        String likeClause = "'" + escapeSQLQuotes(operand.toString()).toUpperCase() + "'";
                        whereClause.append(likeClause);
                    } else {
                        whereClause.append(this.writeOperand(operand));
                    }
                }
            }
        } else if (operator.equals("BETWEEN")) {
            whereClause.append(operandString);
            Object secondOperand = operandIterator.next();
            whereClause.append(" >= ");
            whereClause.append(this.writeOperand(secondOperand));
            whereClause.append(") AND (");
            whereClause.append(operandString);
            secondOperand = operandIterator.next();
            whereClause.append(" <= ");
            whereClause.append(this.writeOperand(secondOperand));
        } else  if (operator.equals("LIKE")) {
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    whereClause.append(operandString);
                    Object operand = operandIterator.next();
                    whereClause.append(" LIKE ");
                    if (operand instanceof String) {
                        //String likeClause = "'%" + escapeSQLQuotes(operand.toString()) + "%'";
                        String likeClause = "'" + escapeSQLQuotes(operand.toString()) + "'";
                        whereClause.append(likeClause);
                    } else {
                        whereClause.append(this.writeOperand(operand));
                    }
                }
            }
        } else  if (operator.equals("BITMASK")) {
            Object secondOperand = operandIterator.next();
            String functionName = this.getBitmaskFunctionName((String) secondOperand);
            Object thirdOperand = operandIterator.next();
            whereClause.append(functionName);
            whereClause.append("(");
            whereClause.append(operandString);
            whereClause.append(", '");
            whereClause.append(operandString);
            whereClause.append("')");
        } else  if (operator.equals("BITSTRING")) {
            Object secondOperand = operandIterator.next();
            String functionName = this.getBitstringFunctionName((String) secondOperand);
            Object thirdOperand = operandIterator.next();
            whereClause.append(functionName);
            whereClause.append("(");
            whereClause.append(operandString);
            whereClause.append(", '");
            whereClause.append(operandString);
            whereClause.append("')");
        } else  if (operator.equals("=")) {
            whereClause.append(operandString);
            Object secondOperand = operandIterator.next();
            whereClause.append(" = ");
            whereClause.append(this.writeOperand(secondOperand));
        } else  if (operator.equals("<>")) {
            whereClause.append(operandString);
            Object secondOperand = operandIterator.next();
            whereClause.append(" <> ");
            whereClause.append(this.writeOperand(secondOperand));
        } else  if (operator.equals(">=")) {
            whereClause.append(operandString);
            Object secondOperand = operandIterator.next();
            whereClause.append(" >= ");
            whereClause.append(this.writeOperand(secondOperand));
        } else  if (operator.equals("<=")) {
            whereClause.append(operandString);
            Object secondOperand = operandIterator.next();
            whereClause.append(" <= ");
            whereClause.append(this.writeOperand(secondOperand));
        } else  if (operator.equals("IN")) {
            whereClause.append(operandString);
            whereClause.append(" IN (");
            if (! operandIterator.hasNext()) {
                //only one
                whereClause.append(operandString);
            } else {
                while (operandIterator.hasNext()) {
                    Object operand = operandIterator.next();
                    whereClause.append(",");
                    whereClause.append(this.writeOperand(operand));
                }
            }
            whereClause.append(")");
        } else {
            whereClause.append(operandString);
        }
        whereClause.append(")");

        return whereClause.toString();
    }

    /**
     * Examines a string and escapes any SQL quotes (<code>'</code>) found.
     * Implements the single-to-double-quote rule specified in SQL92.
     *
     * <p><b>Call: </b>When needed.</p>
     *
     * <p><b>Override: </b>Override this method if your SQL implementation uses
     *                 something other than the single-to-double rule.</p>
     *
     * @param aSqlString The string to be escaped.
     *
     * @return The string with all quotes escaped.
     */
    protected String escapeSQLQuotes(String aSqlString) {
        int apostropheIndex = aSqlString.indexOf("'");
        int priorIndex = -1;

        if (apostropheIndex < 0) {
            return aSqlString;
        }

        StringBuffer outputString = new StringBuffer();

        do {
            outputString = outputString.append(aSqlString.substring(priorIndex + 1, apostropheIndex + 1)).append("'");
            priorIndex = apostropheIndex;
        } while ((apostropheIndex = aSqlString.indexOf("'", priorIndex + 1)) >= 0);

        return outputString.toString();
    }

    /**
     * @param name
     * @return
     */
    protected String convertName(String name) {
        //no translation necessary
        return name;
    }

    /**
     * @param string
     * @return
     */
    protected String getBitstringFunctionName(String operand) {
        String functionName = "eval_bitstring_and";

        if ("OR".equals(operand)) {
            functionName = "eval_bitstring_and";
        } else if ("NOR".equals(operand)) {
            functionName = "eval_bitstring_and";
        }

        return functionName;
    }

    /**
     * @param operand
     * @return
     */
    protected String getBitmaskFunctionName(String operand) {
        String functionName = "eval_bitmask_and";

        if ("OR".equals(operand)) {
            functionName = "eval_bitmask_and";
        } else if ("NOR".equals(operand)) {
            functionName = "eval_bitmask_and";
        }

        return functionName;
    }

    /**
     * @param operand
     * @return
     */
    protected String writeOperand(Object operand) {
        String returnString = "";

        if (operand != null) {
            if (operand instanceof Expression) {
                returnString = this.evaluateExpression((Expression) operand);
            } else if (operand instanceof Calendar) {
                returnString  = this.convertDateToQueryString((Calendar) operand);
            } else if (operand instanceof String) {
                returnString = "'" + escapeSQLQuotes((String) operand) + "'";
            } else {
                returnString = operand.toString();
            }
        }
        return returnString;
    }
    /**
     * Converts a java.util.Calendar object into an date string.
     * This implementation assumes an ISO-8601 simple date format,
     * emitted as a string with a <code>DATE</code> type coercion.
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>When your implementation uses something
     *                     other than the default date/time formatting.</p>
     *
     * @param theTime The date/time to format. The method examines
     *                this argument to determine whether it's formatting
     *                a date, a time of day, or a date/time.
     *
     * @return An date or date/time string suitable for query.
     */
    protected String convertDateToQueryString(java.util.Calendar theTime) {
        String dateFormatString;
        TimeZone tz = null;

        // The input might be a date, a time, or a date/time. Set the
        // format accordingly.
        if (!theTime.isSet(java.util.Calendar.YEAR)) // Time only?
         { // Yes, time only
            dateFormatString = "HH:mm:ss.SSS";
        } else if (!theTime.isSet(java.util.Calendar.HOUR)) // Date only?
         { // Yes, date only
            dateFormatString = "yyyy-MM-dd";
        } else // It's a datetime
         {
            dateFormatString = "yyyy-MM-dd HH:mm:ss.SSS '+0:00'";
            tz = new SimpleTimeZone(0, "GMT");
        }

        SimpleDateFormat aDateFormat = new SimpleDateFormat(dateFormatString);

        if (tz != null) {
            aDateFormat.setTimeZone(tz);
        }

        String dateString = new String(aDateFormat.format(theTime.getTime()));

        return "DATE '" + dateString + "'";
    }

}
