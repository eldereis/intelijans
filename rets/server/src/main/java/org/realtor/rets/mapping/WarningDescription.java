/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/mapping/WarningDescription.java,v 1.4 2005/04/04 16:17:51 ekovach Exp $  */
package org.realtor.rets.mapping;

import org.apache.log4j.Category;
import org.realtor.rets.server.v10.RETSUpdateResponse;

/**
 *  WarningDescription
 *
 *  Copyright 2005, Avantia inc.
 *  @version $Revision: 1.4 $
 *  @author ekovach
 */

/**
    A description of a RETS warning.
 */
public class WarningDescription {
    static Category cat = Category.getInstance(WarningDescription.class);
    
    private String fieldName;
    private String code;
    private String expression;
    private int level;
    private String description;
    private int offset = 0;
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public String getCode() {
        return code;
    }
    
    public boolean evaluate(String value) {
        boolean returnValue = false;
        
        // less than/greater than numeric comparison
        if (expression.startsWith("<") || expression.startsWith(">")) {
    	    try {
    	        double testValue = Double.parseDouble(value);
    	        double expressionValue = Double.parseDouble(expression.substring(1));
    	        if (expression.startsWith("<")) {
    	            returnValue = testValue < expressionValue;
    	        }
    	        else {
    	            returnValue = testValue > expressionValue;
    	        }
    	    }
    	    catch (NumberFormatException e) {
    	        cat.debug("Warning test unable to numerically compare value [" + value + "] to [" + expression.substring(1) + "]");  
    	    }
        }
        return returnValue;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public String toString() {
        return "WarningDescription " + code + ", " + fieldName + ", " + level + ", " + expression + ", " + description;  
    }
}