//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v17/RETSChangePasswordResponse.java,v 1.5 2005/02/18 16:17:08 ekovach Exp $
package org.realtor.rets.server.v17;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;
import org.realtor.rets.util.DesCrypter;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.database.PersistenceException;

import java.io.*;

import java.security.MessageDigest;
import java.util.*;

import javax.servlet.ServletContext;


/**
 *        Generate the Change Password response;
 *
 *        @author        ekovach
 *        @version 1.0
 */
public class RETSChangePasswordResponse extends RETSResponse {

    /** log4j object */
    static Category cat = Category.getInstance(RETSGetObjectResponse.class);

    private Agent user;

    public RETSChangePasswordResponse(Map m, Agent user) {
    	super(m);
    	this.user = user;
    }

    /**
     *  Builds the response, putting the results in the responseMap (see RETSResponse)
     */
    protected void buildResponse() {
    	// get the decrypted new username and password from the PWD request argument
    	// using the old username and password
        String[] pwd = (String[]) requestMap.get("PWD");
        cat.debug("Encrypted username/password is " + pwd[0]);

    	String oldUserName = user.getLogin();
    	String oldPassword = user.getPassword();
        String data = new DesCrypter(makeKey(oldPassword, oldUserName)).decrypt(pwd[0]);
        cat.debug("Decrypted username/password is " + data);

        StringTokenizer st = new StringTokenizer(data, ":");
    	String newPassword = null;
    	String newUserName = null;
        try {
        	newPassword = st.nextToken();
        	newUserName = st.nextToken();
        }
        catch (NoSuchElementException e) {
        	// user name invalid if no password element found?
        	// if so then this is caught by if "(newUserName == null)" below
        }

        if ((newUserName == null) || (! newUserName.equals(oldUserName))) {
        	setReplyCode(REPLY_CODE_ENCRYPTED_USERNAME_INVALID);
        }
        else {
	        if (newPassword.equals(oldPassword)) {
	            setReplyCode(REPLY_CODE_SAME_AS_PREVIOUS_PASSWORD);
	        }
	        else {
	        	if (isSecurePassword(newPassword)) {
	        		user.setPassword(newPassword);
	        		try {
	        			RETSServerApp.getAgentsDAO().saveOrUpdate(user);

	        			//TODO: set the new password for this session?

		        		setReplyCode(REPLY_CODE_SUCCESS);
	        		}
	        		catch (PersistenceException e) {
	        			//TODO: is this an acceptable way to handle a PersistenceException?
		        		setReplyCode(REPLY_CODE_MISC_ERROR);
	        		}
	        	}
	        	else {
	                setReplyCode(REPLY_CODE_INSECURE_PASSWORD);
	        	}
	        }
        }

        cat.debug("Reply code: " + getReplyCode());
        cat.debug("Reply text: " + getReplyText());
    }

    /**
        Make a DES key out of the old password and user name.
        @param oldPassword
        @param username
     */
    private static byte[] makeKey(String password, String username) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            cat.error(e);
        }

        md.reset();

        // trim to 8 bytes
        byte[] key = new byte[8];
        System.arraycopy(md.digest((password + username).toUpperCase()
                                    .getBytes()), 0, key, 0, 8);

        cat.debug("DES key for password/username " + password + "/" + username + " is " + key);
        return key;
    }

    /**
        Return true if the supplied password is considered "secure."
        @param password
        @return true if the supplied password is considered "secure", false otherwise.
     */
    private boolean isSecurePassword(String password) {
    	// TODO: determine if the password is "secure"
    	return true;
    }
}
