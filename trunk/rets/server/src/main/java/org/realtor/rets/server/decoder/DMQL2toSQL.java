/*
 * DMQL2toSQL.java
 *
 * Created on October 8, 2002, 1:46 PM
 */
package org.realtor.rets.server.decoder;

import org.apache.log4j.Category;


//import java.util.*;
//import java.text.*;
//import java.io.*;

/**
 *
 * @author  tweber
 */
public class DMQL2toSQL extends DMQLtoSQL {
	static Category cat = Category.getInstance(DMQL2toSQL.class);
	
    /** Creates a new instance of DMQL2toSQL */
    public DMQL2toSQL(TableDescription desc) {
        super(desc);
    }

    public String convertDMQL(String dmql) throws DMQLParseException {
        String sql = "";
        DMQLTokenizer dmqlTokenStream = new DMQL2Tokenizer(dmql);
        String myToken;

        sql = getSearchCondition(dmqlTokenStream);

        if (dmqlTokenStream.hasMoreTokens()) {
            throw new DMQLParseException(DMQLParseException.CHARACTERS_FOLLOW_QUERY_END);
        }

        return sql;
    }

    public String getSearchCondition(DMQLTokenizer ts)
        throws DMQLParseException {
        String retValue = "";
        String tok = "";

        while (ts.hasMoreTokens()) {
            if (ts.tokenWillBe("(") || ts.tokenWillBe("NOT") ||
                    ts.tokenWillBe("~") || ts.tokenWillBe("|") ||
                    ts.tokenWillBe("OR")) {
                retValue = retValue + getQueryClause(ts);
            } else if (ts.tokenWillBe("AND") || ts.tokenWillBe(",")) {
                retValue = retValue + " AND ";
                tok = ts.getToken();
            } else if (ts.tokenWillBe(")")) {
                return retValue;
            } else {
                cat.error("ERROR: Unexpected tokenization :{" + ts.getToken() + "}");
            }
        }

        return retValue;
    }

    public String getQueryClause(DMQLTokenizer ts) throws DMQLParseException {
        String retValue = "";

        if (ts.tokenWillBe("(") || ts.tokenWillBe("NOT") ||
                ts.tokenWillBe("~")) {
            retValue = retValue + getBooleanElement(ts);
        } else if (ts.tokenWillBe("OR") || ts.tokenWillBe("|")) {
            retValue = retValue + " OR ";
            ts.getToken();
        }

        return retValue;
    }

    public String getBooleanElement(DMQLTokenizer ts) throws DMQLParseException {
        String retValue = "";

        if (ts.tokenWillBe("~") || ts.tokenWillBe("NOT")) {
            String tok = ts.getToken();
            retValue = retValue + "NOT";
        } else {
            retValue = retValue + getQueryElement(ts);
        }

        return retValue;
    }

    public String getQueryElement(DMQLTokenizer ts) throws DMQLParseException {
        String retValue = "";

        //        retValue = getFieldCriteria(ts);
        if (ts.tokenIs("(")) {
            if (ts.tokenWillBe("(")) {
                retValue = retValue + '(' + getSearchCondition(ts) + ')';

                if (ts.tokenIsnt(")")) {
                    cat.error("Expected a ')'");
                }
            } else {
                retValue = retValue + getFieldCriteria(ts);
            }
        }

        return retValue;
    }

    /**
     * Parses a single field criteria.
     *
     * <p><b>Call: </b>Rarely.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the fieldCriteria.
     *
     * @exception DMQLParseException If the fieldCriteria is improperly formed.
     */
    protected String getFieldCriteria(DMQLTokenizer ts)
        throws DMQLParseException {
        String subquery = "";
        String comparisonFieldName;
        String returnValue = null;

        // reading the opening "(" for us in the query-element

        // Can't nest at this level, need to evaluate
        //
        if (ts.tokenWillBe("(")) // It's nested
         {
            // Should not get here
            throw new DMQLParseException(1);
        } else // It's a a fieldCriteria
         {
            // The first token in a query is the field to be compared against.
            comparisonFieldName = ts.getToken();

            if (ts.tokenIsnt("=")) {
                cat.debug("Compare field :" + comparisonFieldName +
                    "  Next Token :" + ts.getToken());
                throw new DMQLParseException(DMQLParseException.EXPECTED_EQUALS);
            }

            // What's allowed next depends on the data type of the comparison
            // field. Validate the comparison field and then continue processing
            // based on its type.
            FieldDescription theField = fTable.getField(comparisonFieldName);

            if (theField == null) {
                throw new DMQLParseException(DMQLParseException.FIELD_NOT_FOUND);
            }

            String dataType = theField.getDataType();
            String interpretation = theField.getInterpretation();

            if (dataType.equals("Character")) {
                if (interpretation.equals("LookupBitstring")) {
                    subquery = subquery + getLookupBitstring(theField, ts);
                } else if (interpretation.equals("LookupMulti")) {
                    subquery = subquery + getLookupMulti(theField, ts);
                } else if (interpretation.equals("Lookup")) {
                    subquery = subquery + getLookupComparison(theField, ts);
                } else {
                    subquery = subquery + getStringComparison(theField, ts);
                }
            } else if (dataType.equals("Date") || dataType.equals("DateTime") ||
                    dataType.equals("Time")) {
                subquery = subquery + getDateComparison(theField, ts);
            } else if (dataType.equals("Boolean")) {
                subquery = subquery + getBooleanComparison(theField, ts);
            } else // Anything else is assumed to be numeric
             {
                if ((interpretation != null) &&
                        interpretation.equals("LookupBitmask")) {
                    subquery = subquery + getLookupBitmask(theField, ts);
                } else // Numeric value is assumed here
                 {
                    subquery = subquery + getNumericComparison(theField, ts);
                }
            }

            returnValue = subquery;
        }

        if (ts.tokenIsnt(")")) {
            cat.debug("Token is :" + ts.getToken());
            throw new DMQLParseException(DMQLParseException.MISSING_CLOSE_PAREN_ON_SUBQUERY);
        }

        return returnValue;
    }
}
