/*
 * DMQL2Tokenizer.java
 *
 * Created on October 10, 2002, 11:13 AM
 */
package org.realtor.rets.server.decoder;

import java.util.Vector;

import org.apache.log4j.Category;


/**
 *
 * @author  tweber
 */
public class DMQL2Tokenizer implements DMQLTokenizer {
    /** Creates a new instance of DMQL2Tokenizer */
    protected static Category cat = Category.getInstance(DMQL2Tokenizer.class);

    private Vector list;
    private int currListItem = -1;
    private int tokenCount = 0;

    public DMQL2Tokenizer(String str) throws DMQLParseException {
        tokenize(str);
    }

    public void tokenize(String str) throws DMQLParseException {
        list = new Vector();
        currListItem = -1;
        tokenCount = 0;

        if (str == null || str.equals("")) {
            return;
        }
        
        String fixedDelims = "()|-+~,&*:?=";
        String whitespace = "   ";

        String currToken = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '\"') {
                cat.debug("Got a quote");

                if (currToken.length() > 0) {
                    list.add(tokenCount++, currToken);
                    currToken = "";
                }

                String literal = processText(str.substring(i));
                i = (i + literal.length()) + 1;
                list.add(tokenCount++, literal);
            } else if (fixedDelims.indexOf(c) > -1) {
                if (currToken.length() > 0) {
                    list.add(tokenCount++, currToken);
                    currToken = "";
                }

                list.add(tokenCount++, "" + c); // so we can treat everything as a string
            } else if (whitespace.indexOf(c) > -1) {
                if ("AND".equalsIgnoreCase(currToken) ||
                        "OR".equalsIgnoreCase(currToken) ||
                        "NOT".equalsIgnoreCase(currToken)) {
                    list.add(tokenCount++, currToken);
                    currToken = "";
                }
            } else {
                currToken = currToken + c;
            }
        }
    }

    public String processText(String str) {
        //String token = str.substring(0, 1);
        String token = "";
        boolean literalDone = false;
        int i = 1;

        for (; (i < str.length()) && !literalDone; i++) {

            if (str.charAt(i) == '\"') {
                if ((i == (str.length() - 1)) || (str.charAt(i + 1) != '\"')) {
                    literalDone = true;
                }
            }
            if (! literalDone) {
                token = token + str.charAt(i);
            }
        }

        return token;
    }

    public boolean tokenIs(String isIt) throws DMQLParseException {
        if (currListItem == -1) {
            currListItem = 0;
        }

        if (currListItem >= list.size()) {
            return false;
        }

        if (isIt.equals((String) list.get(currListItem))) {
            currListItem++;

            return true;
        }

        return false;
    }

    public boolean tokenIsnt(String tok) throws DMQLParseException {
        return !tokenIs(tok);
    }

    public boolean hasMoreTokens() throws DMQLParseException {
        if (currListItem >= list.size()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean tokenWillBe(String tok) throws DMQLParseException {
        if (currListItem >= list.size()) {
            return false;
        }

        if (currListItem < 0) {
            return tok.equals(list.get(0));
        } else {
            return tok.equals(list.get(currListItem));
        }
    }

    public boolean tokenWontBe(String tok) throws DMQLParseException {
        return !tokenWillBe(tok);
    }

    public String getToken() throws DMQLParseException {
        return getNextToken();
    }

    public String getNextToken() {
        if (currListItem >= list.size()) {
            return null;
        }

        if (currListItem < 0) {
            currListItem = 0;
        }

        String retStr = (String) list.get(currListItem++);

        return retStr;
    }

}
