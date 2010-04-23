package org.realtor.rets.server.decoder;

import java.text.*;

// DMQLtoSQL.java
//
// Created Sat Jul 14 06:18:00 America/Phoenix 2001
//
// Part of the RETS implementation library (c) OPT, Inc. 2001
//
// This library is free software; you may redistribute it or
// use it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation.
//
// This library is distributed in the hope that it will be
// useful, but WITHOUT ANY WARRANTY; without even the implied
// warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
// See the GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free
// Software Foundation, Inc., 59 Temple Place, Suite 300,
// Boston MA 02111-1307.
//
// Original author: Bruce Toback, btoback@optc.com
import java.util.*;


/**
 *
 * This class parses a DMQL query and emits an SQL translation.
 *
 *
 * <p>The RETS query language, DMQL, is designed to be database-neutral.
 * This class translates DMQL into SQL, and provides a platform
 * for translating to other query languages as well. It assumes
 * a minimal interface to the RETS metadata, using two interfaces:
 * {@link TableDescription TableDescription} to look
 * up fields, and {@link FieldDescription FieldDescription}
 * for field data type and other information.
 *
 * <p>To customize the class for different dialects of SQL, start by
 * overriding {@link #getStringMatchValue getStringMatchValue}
 * and {@link #getStringMatchOperator getStringMatchOperator}
 * which format string searches. You may also need to override
 * {@link #makeSQLDateConstant makeSQLDateConstant} if your SQL
 * implementation uses something other than ISO-8601 strings
 * for date constants.
 *
 * <p>Several RETS datatypes do not map well into SQL datatypes
 * and query semantics. The bit-oriented types, <code>LookupBitmask</code>
 * and <code>LookupBitstring</code>, have no useful representation
 * in SQL92. The extensions needed to do bit manipulation are nonstandard.
 * Override {@link #getLookupBitmask getLookupBitmask} and
 * {@link #getLookupBitstring getLookupBitstring} to process these.
 * Alternatively, if your database allows it, you can define a stored
 * procedure or function to handle these types, and the base class
 * will call it.
 *
 * <p><code>LookupMulti</code> also doesn't map well into standard
 * SQL constructs. If you override {@link #createLookupMultiQuery createLookupMultiQuery},
 * DMQLtoSQL will still parse the query tokens but will allow you to customize
 * the process of turning the query tokens into an expression.
 *
 * <p>Finally, the RETS <code>Boolean</code> data type has different semantics
 * than SQL booleans, but <code>DMQLtoSQL</code> assumes a direct mapping.
 * Override {@link #getBooleanComparison getBooleanComparison}
 * in order to convert to more normal boolean query semantics.
 */
public class DMQLtoSQL extends Object {
    /**
     * The table description to use when interpreting field names
     * during the parse.
     */
    protected TableDescription fTable;

    /**
     * Public constructor.
     *
     * @param desc The table description to use when parsing the DMQL
     *             string.
     */
    public DMQLtoSQL(TableDescription desc) {
        fTable = desc;
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
     * Examines a string and escapes any SQL quotes (<code>'</code>) found.
     * Implements the single-to-double-quote rule specified in SQL92.
     *
     * <p><b>Call: </b>When needed.</p>
     *
     * <p><b>Override: </b>Override this method if your SQL implementation uses
     *                 something other than the single-to-double rule.</p>
     *
     * @param sqlString The string to be escaped.
     *
     * @return The string with all quotes escaped.
     */
    protected String escapeSQLQuotes(String sqlString) {
        int apostropheIndex = sqlString.indexOf("'");
        int priorIndex = -1;

        if (apostropheIndex < 0) {
            return sqlString;
        } else {
            String outputString = "";

            do {
                outputString = outputString +
                    sqlString.substring(priorIndex + 1, apostropheIndex + 1) +
                    "'";
                priorIndex = apostropheIndex;
            } while ((apostropheIndex = sqlString.indexOf("'", priorIndex + 1)) >= 0);

            return outputString;
        }
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
     * Return the SQL string pattern match operator. The default
     * implementation returns <code>LIKE</code>.
     *
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>When your SQL implementation uses
     *                     or offers string pattern matching other
     *                     than <code>LIKE</code>, for example,
     *                     regular expressions. If you override
     *                     this method, you will probably wish
     *                     to override {@link #getStringMatchValue getStringMatchValue}
     *                     as well.</p>
     *
     * @param field The field being processed for comparison.
     *
     * @return A string containing the text of the SQL string
     *         comparison operator.
     */
    protected String getStringMatchOperator(FieldDescription field) {
        return "LIKE"; // Default OK for many implementations
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
     *
     * @exception DMQLParseException If the list is improperly formed.
     */
    protected String getStringComparison(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        String returnValue = "";
        String matchValue = "";
        boolean isMulti = false;

        do {
            if (returnValue.length() > 0) {
                returnValue = returnValue + ") OR (";

                if (!isMulti) {
                    isMulti = true;
                    returnValue = "(" + returnValue;
                }
            } else {
                returnValue = "(";
            }

            matchValue = getStringMatchValue(field, ts);

            if (field.getUpshiftFlag()) {
                returnValue = returnValue + "UPPER(" + field.getSQLName() +
                    ") LIKE '" + escapeSQLQuotes(matchValue).toUpperCase() +
                    "'";
            } else {
                returnValue = returnValue + field.getSQLName() + " " +
                    getStringMatchOperator(field) + " '" +
                    escapeSQLQuotes(matchValue) + "'";
            }
        } while (ts.tokenIs(","));

        returnValue = returnValue + ")"; // Close the last or only element

        if (isMulti) {
            returnValue = returnValue + ")"; // Close the multi-element OR
        }

        return returnValue;
    }

    /**
     * Parses the right-hand side of a numeric query field. The method handles
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
     * @return An SQL subexpression that evaluates the numeric comparison or comparisons.
     *
     * @exception DMQLParseException If the comparison value could not be parsed
     *            or the list is improperly formed.
     */
    protected String getNumericComparison(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        double firstValue;
        double secondValue;
        String firstArgument;
        String secondArgument = null;
        String returnValue = "";
        boolean isRange = false;
        boolean isMulti = false;

        do {
            if (returnValue.length() > 0) {
                returnValue = returnValue + ") OR (";

                if (!isMulti) {
                    isMulti = true;
                    returnValue = "(" + returnValue;
                }
            } else {
                returnValue = "(";
            }

            firstArgument = ts.getToken();
            firstValue = parseDMQLDouble(field, firstArgument,
                    DMQLParseException.ILLEGAL_NUMBER_IN_RANGE);

            if (ts.tokenIs("+")) {
                returnValue = returnValue + field.getSQLName() + " >= " +
                    firstValue;
            } else if (ts.tokenIs("-")) {
                if (ts.tokenWontBe(",") && ts.tokenWontBe(")")) // If it's not the end, it better be an upper bound
                 {
                    secondArgument = ts.getToken();
                    secondValue = parseDMQLDouble(field, secondArgument,
                            DMQLParseException.ILLEGAL_UPPER_BOUND_IN_RANGE);

                    // Make sure the range is in increasing order (the spec doesn't require it)
                    if (firstValue > secondValue) {
                        String tempString = firstArgument;
                        firstArgument = secondArgument;
                        secondArgument = tempString;
                    }

                    returnValue = returnValue + "(" + field.getSQLName() +
                        " >= " + firstArgument + " AND " + field.getSQLName() +
                        " <= " + secondArgument + ")";
                } else //  "less-than" only, not range
                 {
                    returnValue = returnValue + field.getSQLName() + " <= " +
                        firstArgument;
                }
            } else // Plain number (exact comparison)
             {
                returnValue = returnValue + field.getSQLName() + " = " +
                    firstArgument;
            }
        } while (ts.tokenIs(","));

        returnValue = returnValue + ")"; // Close comparison

        if (isMulti) {
            returnValue = returnValue + ")"; // Close multivalue OR
        }

        return returnValue;
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
    protected String getLookupComparison(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        boolean knotted = ts.tokenIs("~");
        ts.tokenIs("|"); // An OR for a plain lookup is redundant

        String comparisonValue = ts.getToken();

        if (field.getUpshiftFlag()) {
            comparisonValue = comparisonValue.toUpperCase();
        }

        if (ts.tokenWontBe(",")) // Comma-OR?
         {
            return "(" + field.getSQLName() + (knotted ? " <> '" : " = '") +
            comparisonValue + "')";
        }

        // More than just one item. Change to IN syntax.
        String returnValue = field.getSQLName();

        if (knotted) {
            returnValue = returnValue + " NOT";
        }

        returnValue = returnValue + " IN ('" + comparisonValue + "'";

        while (ts.tokenIs(",")) {
            returnValue = returnValue + ", ";
            comparisonValue = ts.getToken();

            if (field.getUpshiftFlag()) {
                comparisonValue = comparisonValue.toUpperCase();
            }

            returnValue = returnValue + "'" + comparisonValue + "'";
        }

        returnValue = returnValue + ")";

        return returnValue;
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
    protected String getBooleanComparison(FieldDescription field,
        DMQLTokenizer ts) throws DMQLParseException {
        double dataValue;
        String argument;

        argument = ts.getToken();

        dataValue = parseDMQLDouble(field, argument,
                DMQLParseException.ILLEGAL_VALUE_FOR_BOOLEAN);

        return "(" + field.getSQLName() + ((dataValue == 0) ? " = " : " <> ") +
        " 0)";
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
     * Converts a java.util.Calendar object into an SQL date constant.
     * This implementation assumes an ISO-8601 simple date format,
     * emitted as a string with a <code>DATE</code> type coercion.
     *
     * <p><b>Call: </b>Rarely. Used internally.</p>
     *
     * <p><b>Override: </b>When your SQL implementation uses something
     *                     other than the default date/time formatting.</p>
     *
     * @param theTime The date/time to format. The method examines
     *                this argument to determine whether it's formatting
     *                a date, a time of day, or a date/time.
     *
     * @return An SQL date or date/time constant.
     */
    protected String makeSQLDateConstant(java.util.Calendar theTime) {
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
    protected String getDateComparison(FieldDescription field, DMQLTokenizer ts)
        throws DMQLParseException {
        java.util.Calendar startTime = null;
        java.util.Calendar endTime = null;
        String returnValue = "";
        boolean isMulti = false;

        do {
            startTime = parseDMQLDate(field, ts);

            if (returnValue.length() > 0) {
                returnValue = returnValue + ") OR (";

                if (!isMulti) {
                    isMulti = true;
                    returnValue = "(" + returnValue;
                }
            } else {
                returnValue = "(";
            }

            if (ts.tokenIs("+")) {
                returnValue = returnValue + field.getSQLName() + " >= " +
                    makeSQLDateConstant(startTime);
            } else if (ts.tokenIs("-")) {
                if (ts.tokenWillBe(")") || ts.tokenWillBe(",")) // It's a straight less-than
                 {
                    returnValue = returnValue + field.getSQLName() + " <= " +
                        makeSQLDateConstant(startTime);
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

                    returnValue = returnValue + "(" + field.getSQLName() +
                        " >= " + makeSQLDateConstant(startTime) + " AND " +
                        field.getSQLName() + " <= " +
                        makeSQLDateConstant(endTime) + ")";
                }
            } else {
                returnValue = returnValue + field.getSQLName() + " = " +
                    makeSQLDateConstant(startTime);
            }
        } while (ts.tokenIs(","));

        return returnValue + ")";
    }

    /**
     * Creates a lookup-multi query from a combination operator
     * and a list of strings representing the query tokens.
     * This implementation assumes that such fields are stored
     * as comma-separated lists of globally-unique tokens --
     * that is, it assumes that each token representing a TRUE value
     * is a substring of the field in storage. Override this
     * method if your storage scheme for lookup-multi fields
     * is different.
     *
     * <p><b>Call: </b>Rarely. Called internally by the parsing logic.</p>
     *
     * <p><b>Override: </b>Override if your storage scheme for
     *                 multi-value lookups differs from that described
     *                 above.</p>
     *
     * @param field The field being queried.
     *
     * @param combinationOp The combination operator found in the query.
     *                      This is represented as one of three strings,
     *                      <code>"AND"</code>, <code>"OR"</code> or
     *                      <code>"NOR"</code>.
     *
     * @param subitems A Vector containing each of the subitem tokens
     *                 as a string.
     */
    protected String createLookupMultiQuery(FieldDescription field,
        String combinationOp, Vector subitems) {
        String returnValue;
        String fieldName = field.getName(); // We'll need it several times
        int i;
        String conjunction;

        if (combinationOp.equals("OR") || combinationOp.equals("NOR")) {
            conjunction = " OR ";
        } else {
            conjunction = " AND ";
        }

        if (combinationOp.equals("NOR")) {
            returnValue = "(NOT (";
        } else {
            returnValue = "(";
        }

        for (i = 0; i < subitems.size(); ++i) {
            if (i > 0) {
                returnValue = returnValue + conjunction;
            }

            returnValue = returnValue + fieldName + " LIKE '" +
                (String) subitems.elementAt(i) + "'";
        }

        if (combinationOp.equals("NOR")) {
            returnValue = returnValue + ")";
        }

        returnValue = returnValue + ")";

        return returnValue;
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
    protected String getLookupBitstring(FieldDescription field, DMQLTokenizer ts)
        throws DMQLParseException {
        String bitString;
        String evalFunction = "eval_bitstring_and";

        if (ts.tokenIs("|")) {
            evalFunction = "eval_bitstring_or";
        } else if (ts.tokenIs("~")) {
            evalFunction = "eval_bitstring_nor";
        } else {
            ts.tokenIs("+"); // AND is the default
        }

        bitString = ts.getToken();

        return evalFunction + "(" + field.getSQLName() + ", '" + bitString +
        "')";
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
    protected String getLookupBitmask(FieldDescription field, DMQLTokenizer ts)
        throws DMQLParseException {
        int rawBits;
        String evalFunction = "eval_bitmask_and";

        if (ts.tokenIs("|")) {
            evalFunction = "eval_bitmask_or";
        } else if (ts.tokenIs("~")) {
            evalFunction = "eval_bitmask_nor";
        } else {
            ts.tokenIs("+"); // AND is the default
        }

        rawBits = parseDMQLInteger(field, ts.getToken(),
                DMQLParseException.ILLEGAL_VALUE_FOR_BITMASK);

        return evalFunction + "(" + field.getSQLName() + ", " +
        Integer.toString(rawBits) + ")";
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
    protected String getLookupMulti(FieldDescription field, DMQLTokenizer ts)
        throws DMQLParseException {
        String returnValue;
        Vector subitems = new Vector();
        String combinationOp;

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

        // Retrieve and save all the subelements
        do {
            String anItem = ts.getToken();
            subitems.add(anItem);
        } while (ts.tokenIs(","));

        return createLookupMultiQuery(field, combinationOp, subitems);
    }

    /**
     * Parses a single subquery.
     *
     * <p><b>Call: </b>Rarely.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param ts    The tokenizer scanning the input string.
     *
     * @return An SQL subexpression that evaluates the subquery.
     *
     * @exception DMQLParseException If the subquery is improperly formed.
     */
    protected String getSubquery(DMQLTokenizer ts) throws DMQLParseException {
        String subquery = "";
        String comparisonFieldName;
        String returnValue = null;

        if (ts.tokenIsnt("(")) {
            throw new DMQLParseException(DMQLParseException.MISSING_OPEN_PAREN_IN_SUBQUERY);
        }

        // There are two choices: this subquery contains the query text, or
        // it contains a nested subquery. Figure out which.
        if (ts.tokenWillBe("(")) // It's nested
         {
            String nestedQuery = "(";

            do {
                if (nestedQuery.length() > 1) {
                    nestedQuery = nestedQuery + " OR ";
                }

                nestedQuery = nestedQuery + getSubquery(ts);
            } while (ts.tokenIs("|"));

            returnValue = nestedQuery + ")";
        } else // It's a query
         {
            // The first token in a query is the field to be compared against.
            comparisonFieldName = ts.getToken();

            if (ts.tokenIsnt("=")) {
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
                if ("LookupBitmask".equals(interpretation)) {
                    subquery = subquery + getLookupBitmask(theField, ts);
                } else // Numeric value is assumed here
                 {
                    subquery = subquery + getNumericComparison(theField, ts);
                }
            }

            returnValue = subquery;
        }

        if (ts.tokenIsnt(")")) {
            throw new DMQLParseException(DMQLParseException.MISSING_CLOSE_PAREN_ON_SUBQUERY);
        }

        return returnValue;
    }

    /**
     * Parses a DMQL query and returns an equivalent SQL expression.
     *
     * <p><b>Call: </b>Freqently. This is the main entry point for the translator.</p>
     *
     * <p><b>Override: </b>Rarely.</p>
     *
     * @param dmql The DMQL string to be translated into SQL.
     *
     * @return An SQL subexpression that evaluates the query.
     */
    public String convertDMQL(String dmql) throws DMQLParseException {
        String sql = "";
        DMQLTokenizer dmqlTokenStream = new DMQL1Tokenizer(dmql, '\\');
        String myToken;

        do {
            if (sql.length() > 0) {
                sql = sql + " AND "; // All top-level subqueries are anded
            }

            sql = sql + getSubquery(dmqlTokenStream);
        } while (dmqlTokenStream.hasMoreTokens() &&
                dmqlTokenStream.tokenIs(","));

        if (dmqlTokenStream.hasMoreTokens()) {
            throw new DMQLParseException(DMQLParseException.CHARACTERS_FOLLOW_QUERY_END);
        }

        return sql;
    }

    class DMQL1Tokenizer implements DMQLTokenizer {
        // This class wraps a standard StringTokenizer and provides
        // DMQL lexical analysis rules
        StringTokenizer tokenizer;
        String escape;
        String cachedToken;
        String dmqlDelimiters;
        String currentToken;

        DMQL1Tokenizer(String theString, char escapeChar) {
            dmqlDelimiters = "()=+-,|&~*?:";
            currentToken = null;
            cachedToken = null;

            // Add the escape string into the list of delimiters
            // if it's not there already. The double-delimiter rule
            // allows the escape to be one of the existing delimiters if
            // needed.
            if (escapeChar != 0) {
                escape = String.valueOf(escapeChar);

                if (dmqlDelimiters.indexOf(escape) < 0) {
                    dmqlDelimiters = dmqlDelimiters + escape;
                }
            } else {
                escape = null;
            }

            tokenizer = new StringTokenizer(theString, dmqlDelimiters, true);
        }

        public boolean hasMoreTokens() {
            return tokenizer.hasMoreTokens();
        }

        public boolean tokenIs(String whatIzit) throws DMQLParseException {
            if (currentToken == null) {
                currentToken = nextToken(true);
            }

            if (currentToken.trim().equals(whatIzit)) {
                currentToken = null;

                return true;
            } else {
                return false;
            }
        }

        public boolean tokenIsnt(String whatIsntIt) throws DMQLParseException {
            return !tokenIs(whatIsntIt);
        }

        public boolean tokenWillBe(String whatWillItBe)
            throws DMQLParseException {
            if (currentToken == null) {
                currentToken = nextToken(false);
            }

            if (currentToken == null) {
                return false;
            } else {
                return currentToken.trim().equals(whatWillItBe);
            }
        }

        public boolean tokenWontBe(String whatWontItBe)
            throws DMQLParseException {
            return !tokenWillBe(whatWontItBe);
        }

        public String getToken() throws DMQLParseException {
            String returnValue;

            if (currentToken == null) {
                returnValue = nextToken(true);
            } else {
                returnValue = currentToken;
                currentToken = null;
            }

            return returnValue;
        }

        String nextToken(boolean mustHaveMoreTokens) throws DMQLParseException {
            String returnValue = null;

            if (cachedToken != null) {
                returnValue = cachedToken;
                cachedToken = null;
            } else if (tokenizer.hasMoreTokens()) {
                returnValue = tokenizer.nextToken();

                if (escape != null) // Need to check for escape?
                 { // Yes, do a look ahead

                    while (tokenizer.hasMoreTokens()) {
                        String lookAhead = tokenizer.nextToken();

                        if (lookAhead.equals(escape)) {
                            if (tokenizer.hasMoreTokens()) {
                                String escapedThing = tokenizer.nextToken();

                                returnValue = returnValue + escapedThing;
                            }
                        } else {
                            // Cache the lookahead and return it for next time
                            cachedToken = lookAhead;

                            break;
                        }
                    }
                }
            } else if (mustHaveMoreTokens) {
                throw new DMQLParseException(DMQLParseException.UNEXPECTED_END_OF_QUERY);
            }

            return returnValue;
        }
    }
}
