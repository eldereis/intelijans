/*
 * Created on Jan 25, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.decoder;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class ParseException extends Exception {
    /**
     * The query text ended in the middle of a construct. This may be caused
     * by an unexpected punctuation mark or a missing right parentheses.
     */
    public static final int UNEXPECTED_END_OF_QUERY = 1;

    /**
     * The parser was scanning a numeric range but could not find
     * a range separator.
     */
    public static final int ILLEGAL_NUMBER_IN_RANGE = 2;

    /**
     * The parser was scanning a numeric range and could not
     * recognize the number that was supposed to be an upper bound.
     */
    public static final int ILLEGAL_UPPER_BOUND_IN_RANGE = 3;

    /**
     * The parser was scanning a query involving a boolean value,
     * but could not recognize the comparison value.
     */
    public static final int ILLEGAL_VALUE_FOR_BOOLEAN = 4;

    /**
     * The parser was scanning a date comparison and encountered
     * a string that could not be parsed as a date or time.
     */
    public static final int ILLEGAL_CALENDAR_FIELD = 5;

    /**
     * The parser was scanning a time value and encountered an hour value
     * outside the range 0..23, or an hour field that could not be
     * converted to a number.
     */
    public static final int ILLEGAL_HOUR_IN_TIME = 6;

    /**
     * The parser was scanning a time value and encountered a minute value
     * outside the range 0..59, or a minute field that could not be
     * converted to a number.
     */
    public static final int ILLEGAL_MINUTE_IN_TIME = 7;

    /**
     * The parser was scanning a time value and encountered a seconds value
     * outside the range 0..59.999, or a seconds field that could not be
     * converted to a number.
     */
    public static final int ILLEGAL_SECOND_IN_TIME = 8;

    /**
     * The parser was scanning a date value and encountered a month value
     * outside the range 1..12, or a month field that could not be
     * converted to a number.
     */
    public static final int ILLEGAL_MONTH_IN_CALENDAR = 9;

    /**
     * The parser was scanning a date value and encountered a year value
     * outside the range 1600..9999, or a year field that could not be
     * converted to a number.
     */
    public static final int ILLEGAL_YEAR_IN_CALENDAR = 10;

    /**
     * The parser was scanning a date value and encountered a day number
     * outside the legal range for the given month, or a day number
     * field that could not be converted to a number.
     */
    public static final int ILLEGAL_DAY_IN_CALENDAR = 11;

    /**
     * The parser was scanning a date/time interval and encountered
     * a comparison between two unlike date types (for example,
     * a date and a date/time).
     */
    public static final int TIME_RANGE_MISMATCH = 12;

    /**
     * The parser was expecting the start of a subquery, but did
     * not find the opening parenthesis.
     */
    public static final int MISSING_OPEN_PAREN_IN_SUBQUERY = 13;

    /**
     * The parser was expecting to find an equal sign <code>(=)</code>
     * following a field name, but found some other punctuation instead.
     */
    public static final int EXPECTED_EQUALS = 14;

    /**
     * The parser could not find the given field name in the table
     * specified in the constructor call.
     */
    public static final int FIELD_NOT_FOUND = 15;

    /**
     * The parser encountered the end of a subquery but did not find
     * a closing parenthesis. This may be caused by an extra comma
     * in a list or by some unexpected punctuation in a string
     * comparison.
     */
    public static final int MISSING_CLOSE_PAREN_ON_SUBQUERY = 16;

    /**
     * The parser was scanning the query for a <code>LookupBitstring</code>
     * or <code>LookupBitmap</code> field, and did not find the
     * required boolean operator (<code>|</code>, <code>+</code> or <code>~</code>).
     */
    public static final int MISSING_MULTI_BOOLEAN_OP = 17;

    /**
     * The parser was scanning the query for a <code>LookupBitmask</code>
     * field and encountered something other than an integer for
     * the search value.
     */
    public static final int ILLEGAL_VALUE_FOR_BITMASK = 18;

    /**
     * The parser found the logical end of the query but
     * additional characters followed. This may be caused by an
     * extra right parenthesis in a subquery.
     */
    public static final int CHARACTERS_FOLLOW_QUERY_END = 19;

    /**
     * The cause of the exception.
     */
    protected int exceptionType;

    
    public int getExceptionCode() {
        return exceptionType;
    }
 
    public abstract String getMessage();
}
