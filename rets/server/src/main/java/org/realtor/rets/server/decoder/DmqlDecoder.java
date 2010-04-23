/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.decoder;

import java.util.SimpleTimeZone;
import java.util.Vector;

import org.apache.log4j.Category;
import org.realtor.rets.server.RETSResponse;
import org.realtor.rets.server.SearchQuery;


/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DmqlDecoder implements QueryDecoder {
    protected static Category cat = Category.getInstance(DmqlDecoder.class);

    protected TableDescription fTable = null;
    
    /**
     * @return Returns the fTable.
     */
    public TableDescription getFTable() {
        return fTable;
    }
    /**
     * @param table The fTable to set.
     */
    public void setFTable(TableDescription table) {
        fTable = table;
    }
    
    /* (non-Javadoc)
     * @see org.realtor.rets.server.decoder.QueryDecoder#decode(java.lang.String)
     */
    public SearchQuery decode(String query) throws DMQLParseException {
        Expression criteria = null;
        String myToken = null;
        if (query == null || ! query.startsWith("(")) {
            throw new DMQLParseException(RETSResponse.REPLY_CODE_INVALID_QUERY_SYNTAX);
        }
        SearchQuery decodedQuery = new SearchQuery();
        DMQLTokenizer dmqlTokenStream = new DMQL2Tokenizer(query);
        criteria = getSearchCondition(dmqlTokenStream);
        if (dmqlTokenStream.hasMoreTokens()) {
            throw new DMQLParseException(ParseException.CHARACTERS_FOLLOW_QUERY_END);
        }
        decodedQuery.setQueryExpression(criteria);
        return decodedQuery;
    }

    /**
     * @param dmqlTokenStream
     * @return
     * @throws DMQLParseException 
     */
    private Expression getSearchCondition(DMQLTokenizer ts) throws DMQLParseException {
        String retValue = "";
        String tok = "";
        Expression searchExpression = new Expression();
        while (ts.hasMoreTokens()) {
            if (ts.tokenWillBe("(")) {
                //throw away enclosing paren and recurse
                ts.getToken();
                searchExpression.addOperand(this.getSearchCondition(ts));
            } else if (ts.tokenWillBe("NOT") || ts.tokenWillBe("~")) {
                ts.getToken();
                searchExpression.setOperator("NOT");
            } else if (ts.tokenWillBe("AND") || ts.tokenWillBe(",")) {
                ts.getToken();
                searchExpression.setOperator("AND");
            } else if (ts.tokenWillBe("OR") || ts.tokenWillBe("|")) {
                ts.getToken();
                searchExpression.setOperator("OR");
            } else if (ts.tokenWillBe(")")) {
                ts.getToken();
                return searchExpression;
            } else {
                searchExpression = this.getFieldExpression(ts);
            }
        }

        return searchExpression;
    }
    
    private Expression getFieldExpression(DMQLTokenizer ts) throws DMQLParseException {
        Expression fieldExpression = null;
        String dataType = null;
        String interpretation = null;
        
        String comparisonFieldName = ts.getToken();
        cat.debug("comparisonFieldName:"+comparisonFieldName);

        String operatorToken = ts.getToken();
        cat.debug("operatorToken:"+operatorToken);
        
        if (! "=".equals(operatorToken)) {
            //FIXME 
            throw new DMQLParseException(ParseException.EXPECTED_EQUALS);
        }
        
        
        // What's allowed next depends on the data type of the comparison
        // field. Validate the comparison field and then continue processing
        // based on its type.
        FieldDescription theField = fTable.getField(comparisonFieldName);

        if (theField == null) {
            throw new DMQLParseException(ParseException.FIELD_NOT_FOUND);
        }
        
        dataType = theField.getDataType();
        cat.debug("dataType= "+dataType);
            
        interpretation = theField.getInterpretation();
        cat.debug("interpretation= "+interpretation);
            
        if (dataType.equals("Character")) {
            if (interpretation.equals("LookupBitstring")) {
                fieldExpression = getLookupBitstring(theField, ts); 
            } else if (interpretation.equals("LookupMulti")) {
                fieldExpression = getLookupMulti(theField, ts); 
            } else if (interpretation.equals("Lookup")) {
                fieldExpression = getLookupComparison(theField, ts); 
            } else {
                fieldExpression = getStringComparison(theField, ts); 
            }
        } else if (dataType.equals("Date") || dataType.equals("DateTime") ||
                dataType.equals("Time")) {
            fieldExpression = getDateComparison(theField, ts); 
        } else if (dataType.equals("Boolean")) {
            fieldExpression = getBooleanComparison(theField, ts); 
        } else // Anything else is assumed to be numeric
         {
            if ("LookupBitmask".equals(interpretation)) {
                fieldExpression = getLookupBitmask(theField, ts); 
            } else // Numeric value is assumed here
             {
                fieldExpression = getNumericComparison(theField, ts); 
            }
        }
            cat.debug("fieldExpression= "+fieldExpression);
        return fieldExpression;
    }
    
    
    /**
     * Parses an integer with DMQLParser exception processing.
     *
     * <p><b>Call: </b>When needed.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param field The field descriptor to use when reporting exceptions.
     *
     * @param string The string to parse.
     *
     * @param exceptionID The ID of the exception to throw if the string can't
     *                    be converted.
     *
     * @return The value of <code>string</code> as an integer.
     *
     * @exception DMQLParseException If the value can't be converted.
     */
    protected int parseDMQLInteger(FieldDescription field, String string,
        int exceptionID) throws DMQLParseException {
        int returnValue;

        try {
            returnValue = Integer.valueOf(string).intValue();
        } catch (NumberFormatException e) {
            throw new DMQLParseException(exceptionID, field.getName());
        }

        return returnValue;
    }

    /**
     * Parses a double with DMQLParser exception processing.
     *
     * <p><b>Call: </b>When needed.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param field The field descriptor to use when reporting exceptions.
     *
     * @param string The string to parse.
     *
     * @param exceptionID The ID of the exception to throw if the string can't
     *                    be converted.
     *
     * @return The value of <code>string</code> as a double.
     *
     * @exception DMQLParseException If the value can't be converted.
     */
    protected double parseDMQLDouble(FieldDescription field, String string,
        int exceptionID) throws DMQLParseException {
        double returnValue;

        try {
            returnValue = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            throw new DMQLParseException(exceptionID, field.getName());
        }

        return returnValue;
    }    
    
    /**
     * @param theField
     * @param ts
     * @return
     */
    private Expression getNumericComparison(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        double firstValue;
        double secondValue;
        String firstArgument;
        String secondArgument = null;
        String returnValue = "";
        boolean isRange = false;
        boolean isMulti = false;
        Expression numericExpression = null;
        Expression returnExpression = new Expression();
        
        returnExpression.setOperator("OR");

        do {
            numericExpression = new Expression();
            firstArgument = ts.getToken();
            firstValue = parseDMQLDouble(field, firstArgument,
                    DMQLParseException.ILLEGAL_NUMBER_IN_RANGE);

            if (ts.tokenIs("+")) {
                numericExpression.addOperand(field.getSQLName());
                numericExpression.addOperand(new Double(firstValue));
                numericExpression.setOperator(">=");
            } else if (ts.tokenIs("-")) {
                if (ts.tokenWontBe(",") && ts.tokenWontBe(")")) // If it's not the end, it better be an upper bound
                 {
                    secondArgument = ts.getToken();
                    secondValue = parseDMQLDouble(field, secondArgument,
                            DMQLParseException.ILLEGAL_UPPER_BOUND_IN_RANGE);

                    // Make sure the range is in increasing order (the spec doesn't require it)
                    if (firstValue > secondValue) {
                        double temp = firstValue;
                        firstValue = secondValue;
                        secondValue = temp;
                    }

                    numericExpression.addOperand(field.getSQLName());
                    numericExpression.addOperand(new Double(firstValue));
                    numericExpression.addOperand(new Double(secondValue));
                    numericExpression.setOperator("BETWEEN");

                 } else //  "less-than" only, not range
                 {
                     numericExpression.addOperand(field.getSQLName());
                     numericExpression.addOperand(new Double(firstValue));
                     numericExpression.setOperator("<=");
                }
            } else // Plain number (exact comparison)
             {
                numericExpression.addOperand(field.getSQLName());
                numericExpression.addOperand(new Double(firstValue));
                numericExpression.setOperator("=");
            }
            returnExpression.addOperand(numericExpression);
        } while (ts.tokenIs(","));

        return returnExpression;

    }

    /**
     * Parses the right-hand side of a boolean query field.
     * This implementation assumes that a boolean
     * field is a numeric field with a value of zero for <code>false</code>
     * and nonzero for <code>true</code>.
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>When your method of storing boolean fields
     *                 is something other than numeric.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the Boolean comparison.
     *
     * @exception DMQLParseException If the comparison value could not be parsed.
     */
    private Expression getBooleanComparison(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        double dataValue = 0;
        String argument = null;

        argument = ts.getToken();
        dataValue = parseDMQLDouble(field, argument,
                DMQLParseException.ILLEGAL_VALUE_FOR_BOOLEAN);
        Expression booleanExpression = new Expression();
        booleanExpression.setOperator(((dataValue == 0) ? "=" : "<>"));
        booleanExpression.addOperand(field.getSQLName());
        booleanExpression.addOperand(new Integer(0));

        return booleanExpression;
    }
    /**
     * Parses a DMQL date or date/time.
     * Returns the date or datetime as a <code>java.util.Calendar</code> object.
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return A java.util.Calendar object that represents the date or date/time.
     *
     * @exception DMQLParseException If the date could not be parsed or
     *            contains invalid date/time fields.
     */
    protected java.util.Calendar parseDMQLDate(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        String theToken = ts.getToken();
        int firstTokenValue;
        java.util.Calendar whenever = null;
        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int minute = 0;
        double second = 0.0;
        boolean hasDate = false;
        boolean hasTime = false;

        // There are a number of possibilities for the first token.
        // It might be a keyword, or it might be a year, or it might
        // be an hour. We don't know in advance.
        if (theToken.equals("NOW")) // Current date and time
         {
            return new java.util.GregorianCalendar();
        }

        if (theToken.equals("TODAY")) // Current date
         {
            whenever = new java.util.GregorianCalendar();
            whenever.clear(java.util.Calendar.MILLISECOND);
            whenever.clear(java.util.Calendar.SECOND);
            whenever.clear(java.util.Calendar.MINUTE);
            whenever.clear(java.util.Calendar.HOUR);

            return whenever;
        }

        firstTokenValue = parseDMQLInteger(field, theToken,
                DMQLParseException.ILLEGAL_CALENDAR_FIELD);

        // Determine whether we have a time or a date/datetime. If the
        // separator token is a colon, it's a time. If it's a hyphen,
        // we have a date. If it's neither, we have a parse exception.
        if (ts.tokenIs(":")) // Time?
         { // Yes
            hasTime = true;

            if ((firstTokenValue < 0) || (firstTokenValue > 23)) {
                throw new DMQLParseException(DMQLParseException.ILLEGAL_HOUR_IN_TIME,
                    field.getName());
            }

            hour = firstTokenValue;
            minute = parseDMQLInteger(field, ts.getToken(),
                    DMQLParseException.ILLEGAL_MINUTE_IN_TIME);

            if ((minute < 0) || (minute > 59)) {
                throw new DMQLParseException(DMQLParseException.ILLEGAL_MINUTE_IN_TIME,
                    field.getName());
            }

            if (ts.tokenIsnt(":")) {
                throw new DMQLParseException(DMQLParseException.ILLEGAL_CALENDAR_FIELD);
            }

            second = parseDMQLDouble(field, ts.getToken(),
                    DMQLParseException.ILLEGAL_SECOND_IN_TIME);

            if ((second < 0.0) || (second >= 60.0)) {
                throw new DMQLParseException(DMQLParseException.ILLEGAL_SECOND_IN_TIME,
                    field.getName());
            }
        } else if (ts.tokenIs("-")) // Date or datetime?
         { // Yes
            hasDate = true;
            year = firstTokenValue;
            theToken = ts.getToken();
            month = parseDMQLInteger(field, theToken,
                    DMQLParseException.ILLEGAL_MONTH_IN_CALENDAR);

            if (ts.tokenIsnt("-")) {
                throw new DMQLParseException(DMQLParseException.ILLEGAL_CALENDAR_FIELD,
                    field.getName());
            }

            theToken = ts.getToken();

            // theToken now contains either a day number or, because of the
            // way the lexer works, <day>T<hour>. See which it is. If it's the
            // datetime form, get the time as well.
            int tee = theToken.indexOf("T");

            if (tee < 0) // Just a date
             {
                day = parseDMQLInteger(field, theToken,
                        DMQLParseException.ILLEGAL_DAY_IN_CALENDAR);
            } else // Date and time
             {
                hasTime = true;

                day = parseDMQLInteger(field, theToken.substring(0, tee),
                        DMQLParseException.ILLEGAL_DAY_IN_CALENDAR);

                if (theToken.length() <= (tee + 1)) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_DAY_IN_CALENDAR,
                        field.getName());
                }

                hour = parseDMQLInteger(field, theToken.substring(tee + 1),
                        DMQLParseException.ILLEGAL_HOUR_IN_TIME);

                if ((hour < 0) || (hour > 23)) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_HOUR_IN_TIME,
                        field.getName());
                }

                if (ts.tokenIsnt(":")) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_CALENDAR_FIELD);
                }

                theToken = ts.getToken();
                minute = parseDMQLInteger(field, theToken,
                        DMQLParseException.ILLEGAL_MINUTE_IN_TIME);

                if ((minute < 0) || (minute > 59)) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_MINUTE_IN_TIME,
                        field.getName());
                }

                if (ts.tokenIsnt(":")) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_CALENDAR_FIELD);
                }

                second = parseDMQLDouble(field, ts.getToken(),
                        DMQLParseException.ILLEGAL_SECOND_IN_TIME);

                if ((second < 0.0) || (second >= 60.0)) {
                    throw new DMQLParseException(DMQLParseException.ILLEGAL_SECOND_IN_TIME,
                        field.getName());
                }
            }
        } else {
            throw new DMQLParseException(DMQLParseException.ILLEGAL_CALENDAR_FIELD,
                field.getName());
        }

        whenever = new java.util.GregorianCalendar();
        whenever.clear();

        if (hasTime) {
            whenever.setTimeZone(new SimpleTimeZone(0, "GMT"));
            whenever.set(java.util.Calendar.HOUR, hour);
            whenever.set(java.util.Calendar.MINUTE, minute);
            whenever.set(java.util.Calendar.SECOND, (int) second);
            whenever.set(java.util.Calendar.MILLISECOND,
                ((int) (second * 1000.0)) % 1000);
        }

        if (hasDate) {
            whenever.set(java.util.Calendar.YEAR, year);
            whenever.set(java.util.Calendar.MONTH, month - 1);
            whenever.set(java.util.Calendar.DATE, day);
        }

        return whenever;
    }



    /**
     * Parses the right-hand side of a date or date/time query field. The method handles
     * multiple comma-ORed matches.
     *
     * <p><b>Call: </b>Rarely.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the date or date/time comparison.
     */
    protected Expression getDateComparison(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        java.util.Calendar startTime = null;
        java.util.Calendar endTime = null;
        String returnValue = "";
        boolean isMulti = false;
        Expression returnExpression = new Expression();
        Expression dateExpression = null;
        
        returnExpression.setOperator("OR");
        
        do {
            startTime = parseDMQLDate(field, ts);
            dateExpression = new Expression();
            if (ts.tokenIs("+")) {
                dateExpression.setOperator(">=");
                dateExpression.addOperand(field.getSQLName());
                dateExpression.addOperand(startTime);
            } else if (ts.tokenIs("-")) {
                if (ts.tokenWillBe(")") || ts.tokenWillBe(",")) {
                  // It's a straight less-than
                    dateExpression.setOperator("<=");
                    dateExpression.addOperand(field.getSQLName());
                    dateExpression.addOperand(startTime);
                } else // It's a range
                 {
                    endTime = parseDMQLDate(field, ts);

                    // Do some basic checking to see if this might be a reasonable
                    // comparison. In particular, the same parts of each date/time
                    // must be specified.
                    if ((startTime.isSet(java.util.Calendar.YEAR) ^
                            endTime.isSet(java.util.Calendar.YEAR)) ||
                            (startTime.isSet(java.util.Calendar.HOUR) ^
                            endTime.isSet(java.util.Calendar.HOUR))) {
                        throw new DMQLParseException(DMQLParseException.TIME_RANGE_MISMATCH,
                            field.getName());
                    }

                    // Arrange start and end to be increasing.
                    if (endTime.before(startTime)) {
                        java.util.Calendar tempCalendar = endTime;
                        endTime = startTime;
                        startTime = tempCalendar;
                    }
                    Expression rangeExpression = new Expression();
                    rangeExpression.setOperator(">=");
                    rangeExpression.addOperand(field.getSQLName());
                    rangeExpression.addOperand(startTime);
                    dateExpression.addOperand(rangeExpression);
                    rangeExpression = new Expression();
                    rangeExpression.setOperator(">=");
                    rangeExpression.addOperand(field.getSQLName());
                    rangeExpression.addOperand(endTime);
                    dateExpression.addOperand(rangeExpression);
                    dateExpression.setOperator("AND");
                    
                }
            } else {
                dateExpression.setOperator("=");
                dateExpression.addOperand(field.getSQLName());
                dateExpression.addOperand(startTime);
            }
            returnExpression.addOperand(dateExpression);
        } while (ts.tokenIs(","));

        return returnExpression;
    }

    
    /**
     * Parses a string match target that may include "wildcards".
     * Note that there is wide variability in
     * the way that SQL implementations handle mid-string searches. This
     * implementation doesn't handle single-character mid-string searches
     * (for example, <code>PREFIX?SUFFIX</code> where the <code>?</code> is
     * intended to match only a single character). Instead, the question
     * mark is expanded to another arbitrary-length insertion.
     *
     * <p><b>Call: </b>When needed.</p>
     *
     * <p><b>Override: </b>When your SQL implementation uses
     *                     conventions different from those described above.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return A string that can be used as an argument to the
     *         SQL <code>LIKE</code> operator.
     */
    protected String getStringMatchValue(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        String matchValue;

        if (ts.tokenIs("*")) {
            matchValue = "%";

            // We assume that the string is being generated by something
            // that has a high probability of getting it "right". Therefore,
            // we assume that the syntax of an element is correct, at least
            // for errors that won't cause the parser to loop or abort.
            matchValue = matchValue + ts.getToken();

            if (ts.tokenIs("*")) {
                matchValue = matchValue + "%";
            }
        } else {
            matchValue = ts.getToken();

            if (ts.tokenIs("?")) {
                matchValue = matchValue + "%"; // This works for *some* SQL implementations
                matchValue = matchValue + ts.getToken();
            } else if (ts.tokenIs("*")) {
                matchValue = matchValue + "%";
            }
        }

        return matchValue;
    }
    
    /**
     * Parses the right-hand side of a string query field. The method handles
     * multiple comma-ORed matches.
     *
     * <p><b>Call: </b>When needed for an override of
     *                {@link #getStringComparison getStringComparison}.</p>
     *
     * <p><b>Override: </b>Rarely. Override {@link #getStringMatchValue getStringMatchValue} and
     *                 {@link #getStringMatchOperator getStringMatchOperator} to customize string
     *                 matching for your SQL implementation.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the string comparison.
     * @throws DMQLParseException 
     *
     * @exception DMQLParseException If the list is improperly formed.
     */
    private Expression getStringComparison(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        String returnValue = "";
        String matchValue = "";
        boolean isMulti = false;
        Expression stringExpression = null;
        Expression returnExpression = new Expression();
        
        returnExpression.setOperator("OR");
        do {
            matchValue = getStringMatchValue(field, ts);
            
            // TODO: encode the match value if possible
            String value = LookupNameDecoder.encodeStandardValue(field.getName(), matchValue);
            stringExpression = new Expression();
            if (field.getUpshiftFlag()) {
                stringExpression.setOperator("MATCHES");
                stringExpression.addOperand(field.getSQLName());
                stringExpression.addOperand(value);
            } else {
                stringExpression.setOperator("LIKE");
                stringExpression.addOperand(field.getSQLName());
                stringExpression.addOperand(value);
            }
            returnExpression.addOperand(stringExpression);
        } while (ts.tokenIs(","));

        return returnExpression;
    }

    /**
     * Parses the right-hand side of a lookup query field. The method handles
     * multiple comma-ORed matches. This implementation assumes that a lookup
     * field is a plain text field and does an exact string comparison. It
     * also assumes that the SQL implementation has a set-membership
     * operator (<code>IN</code>).
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>When your method of storing lookup fields
     *                 is something other than plain text, or when
     *                 your SQL implementation doesn't provide a
     *                 set membership operation.</p>
     *
     * @param field The field used in the comparison.
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the lookup field comparison.
     *
     * @exception DMQLParseException If the list is improperly formed.
     */
    private Expression getLookupComparison(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        boolean invert = ts.tokenIs("~");
        ts.tokenIs("|"); // An OR for a plain lookup is redundant
        Expression returnExpression = new Expression();
        returnExpression.setOperator("IN");
        returnExpression.addOperand(field.getSQLName());
        
        String comparisonValue = ts.getToken();
        if (field.getUpshiftFlag()) {
            comparisonValue = comparisonValue.toUpperCase();
        }

        if (ts.tokenWontBe(",")) {
            returnExpression.addOperand(comparisonValue);
            returnExpression.setOperator(invert ? "<>" : "=");
        } else {
            if (invert) {
                returnExpression.setOperator("NOTIN");
            }
            returnExpression.addOperand(comparisonValue);
    
            while (ts.tokenIs(",")) {
                comparisonValue = ts.getToken();
                if (field.getUpshiftFlag()) {
                    comparisonValue = comparisonValue.toUpperCase();
                }
                returnExpression.addOperand(comparisonValue);
            }
        }
        
        return returnExpression;
    }
    
    /**
     * Parses a LookupMulti item, which is assumed to contain a
     * lookup-list query. There is no obvious storage format
     * for a lookup-multi field in an SQL database, so this method
     * simply parses the lookup-multi field and hands it off to
     * {@link #createLookupMultiQuery createLookupMultiQuery} to be formatted into SQL.
     * Override {@link #createLookupMultiQuery createLookupMultiQuery} in order to implement
     * the storage scheme for a LookupMulti field.
     *
     * <p><b>Call: </b>Rarely. Called internally by the parsing logic.</p>
     *
     * <p><b>Override: </b>Rarely. Override {@link #createLookupMultiQuery createLookupMultiQuery}
     *                 instead.
     *
     * @param ts The tokenizer scanning the input string.
     *
     * @param field The field being evaluated.
     *
     * @return An SQL subexpression that evaluates the query.
     *
     * @exception DMQLParseException If the list is malformed.
     */
    private Expression getLookupMulti(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        String returnValue;
        Vector subitems = new Vector();
        String combinationOp;
        Expression returnExpression = new Expression();
        Expression multiExpression = null;
        
        if (ts.tokenIs("|")) {
            combinationOp = "OR";
        } else if (ts.tokenIs("+")) {
            combinationOp = "AND";
        } else if (ts.tokenIs("~")) {
            combinationOp = "NOR";
        } else {
            throw new DMQLParseException(DMQLParseException.MISSING_MULTI_BOOLEAN_OP,
                field.getName());
        }

        returnExpression.setOperator(combinationOp);
        // Retrieve and save all the subelements
        do {
            multiExpression = new Expression();
            multiExpression.setOperator("LIKE");
            String anItem = ts.getToken();
            multiExpression.addOperand("%" + anItem + "%");
            returnExpression.addOperand(multiExpression);
        } while (ts.tokenIs(","));

        return returnExpression;
    }

    
    /**
     * Parses a LookupBitstring item. There really isn't any good SQL
     * representation of this type, so this procedure punts by assuming
     * the existence of a stored function to evaluate it. Presumably,
     * an SQL-based RETS server either won't use this data type, or will
     * have some back-end-specific way of dealing with it.
     *
     * <p><b>Call: </b>Rarely. Called internally by the parsing logic.</p>
     *
     * <p><b>Override: </b>Almost always, unless there are no LookupBitstring
     *                     items in the data base.</b>
     *
     * @param ts The tokenizer scanning the input string.
     *
     * @param field The field being evaluated.
     *
     * @return An SQL subexpression that evaluates the query.
     *
     * @exception DMQLParseException If the item is malformed.
     */
    protected Expression getLookupBitstring(FieldDescription field, DMQLTokenizer ts)
        throws DMQLParseException {
        String bitString;
        Expression returnExpression = new Expression();
        
        returnExpression.setOperator("BITSTRING");
        returnExpression.setOperator(field.getSQLName());
        
        if (ts.tokenIs("|")) {
            returnExpression.addOperand("OR");
        } else if (ts.tokenIs("~")) {
            returnExpression.addOperand("NOR");
        } else {
            returnExpression.addOperand("AND");
            ts.tokenIs("+"); 
        }

        bitString = ts.getToken();
        returnExpression.addOperand(bitString);

        return returnExpression;
    }

    /**
     * Parses a LookupBitmask item. There really isn't any good SQL
     * representation of this type, so this procedure punts by assuming
     * the existence of a stored function to evaluate it. Presumably,
     * an SQL-based RETS server either won't use this data type, or will
     * have some back-end-specific way of dealing with it.
     *
     * <p><b>Call: </b>Rarely. Called internally by the parsing logic.</p>
     *
     * <p><b>Override: </b>Almost always, unless there are no LookupBitmask
     *                     items in the data base.</b>
     *
     * @param ts The tokenizer scanning the input string.
     *
     * @param field The field being evaluated.
     *
     * @return An SQL subexpression that evaluates the query.
     *
     * @exception DMQLParseException If the item is malformed or the bitmask
     *                               value can't be parsed.
     */
    protected Expression getLookupBitmask(FieldDescription field, DMQLTokenizer ts) throws DMQLParseException {
        int rawBits;
        Expression returnExpression = new Expression();
        
        returnExpression.setOperator("BITMASK");
        returnExpression.setOperator(field.getSQLName());
        
        if (ts.tokenIs("|")) {
            returnExpression.addOperand("OR");
        } else if (ts.tokenIs("~")) {
            returnExpression.addOperand("NOR");
        } else {
            returnExpression.addOperand("AND");
            ts.tokenIs("+"); 
        }

        rawBits = parseDMQLInteger(field, ts.getToken(),
                DMQLParseException.ILLEGAL_VALUE_FOR_BITMASK);
        returnExpression.addOperand(Integer.toString(rawBits));

        return returnExpression;
    }
    
}
