package org.realtor.rets.server.decoder;

public class DMQLParseException extends ParseException {

    /**
     * The name of the field being processed when the exception occurred.
     */
    protected String errorField;

    /**
     * Constructs an exception that does not reference a specific field.
     *
     * @param exception An integer representing the cause of the exception.
     */
    public DMQLParseException(int exception) {
        exceptionType = exception;
        errorField = null;
    }

    /**
     * Constructs an exception that references a specific field.
     *
     * @param exception An integer representing the cause of the exception.
    *
    * @param currentField The field being processed when the error occurred.
    */
    public DMQLParseException(int exception, String currentField) {
        exceptionType = exception;
        errorField = currentField;
    }

    /**
     * Returns the field being processed when the exception occurred, or
     * <code>"(Unknown)"</code> if no field was being processed at the time.
     *
     * @return A string to use as the field name when reporting the exception.
     */
    protected final String getSafeCurrentField() {
        if (errorField == null) {
            return "(unknown)";
        } else {
            return errorField;
        }
    }
   
    /**
     * Returns a message describing the exception.
     *
     * @return A message describing the exception.
     */
    public String getMessage() {
        switch (exceptionType) {
        case UNEXPECTED_END_OF_QUERY:
            return "Unexpected end of query.";

        case ILLEGAL_NUMBER_IN_RANGE:
            return "Illegal number in range for field " +
            getSafeCurrentField() + ".";

        case ILLEGAL_UPPER_BOUND_IN_RANGE:
            return "Illegal upper bound in range for field " +
            getSafeCurrentField() + ".";

        case ILLEGAL_VALUE_FOR_BOOLEAN:
            return "Illegal boolean value for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_CALENDAR_FIELD:
            return "Unrecognizable date/time value for field " +
            getSafeCurrentField() + ".";

        case ILLEGAL_HOUR_IN_TIME:
            return "Illegal hours value for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_MINUTE_IN_TIME:
            return "Illegal minutes value for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_SECOND_IN_TIME:
            return "Illegal seconds value for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_MONTH_IN_CALENDAR:
            return "Illegal month number for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_YEAR_IN_CALENDAR:
            return "Illegal year number for field " + getSafeCurrentField() +
            ".";

        case ILLEGAL_DAY_IN_CALENDAR:
            return "Illegal day number for field " + getSafeCurrentField() +
            ".";

        case TIME_RANGE_MISMATCH:
            return "Date/time types don't match on field " +
            getSafeCurrentField() + ".";

        case MISSING_OPEN_PAREN_IN_SUBQUERY:
            return "Missing open parenthesis in subquery.";

        case EXPECTED_EQUALS:
            return "Missing equals sign after field name.";

        case FIELD_NOT_FOUND:
            return "FieldDescription " + getSafeCurrentField() +
            " not in table.";

        case MISSING_CLOSE_PAREN_ON_SUBQUERY:
            return "Missing close parenthesis on subquery.";

        case MISSING_MULTI_BOOLEAN_OP:
            return "Missing combinatorial operator on multi-select field " +
            getSafeCurrentField() + ".";

        case ILLEGAL_VALUE_FOR_BITMASK:
            return "Uninterpretable number for bitmask value on field " +
            getSafeCurrentField() + ".";

        case CHARACTERS_FOLLOW_QUERY_END:
            return "Characters follow the logical end of the query.";

        default:
            return "Unknown DMQL exception (" + Integer.toString(exceptionType) +
            ")";
        }
    }
}
