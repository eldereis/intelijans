/*
 * DMQLTokenizer.java
 *
 * Created on October 10, 2002, 1:25 PM
 */
package org.realtor.rets.server.decoder;


/**
 *
 * @author  tweber
 */
public interface DMQLTokenizer {
    public boolean tokenWillBe(String token) throws DMQLParseException;

    public boolean tokenWontBe(String token) throws DMQLParseException;

    public boolean tokenIs(String token) throws DMQLParseException;

    public boolean tokenIsnt(String token) throws DMQLParseException;

    public boolean hasMoreTokens() throws DMQLParseException;

    public String getToken() throws DMQLParseException;
}
