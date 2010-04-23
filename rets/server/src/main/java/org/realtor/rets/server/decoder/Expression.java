/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.decoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Expression {

    private String operator = "";
    private List operands = new ArrayList();
    
    /**
     * @return Returns the operands.
     */
    public List getOperands() {
        return operands;
    }
    /**
     * @return Returns the operator.
     */
    public String getOperator() {
        return operator;
    }
    /**
     * @param operands The operands to set.
     */
    public void setOperands(List operands) {
        this.operands = operands;
    }
    /**
     * @param operator The operator to set.
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    public void addOperand(Object operand) {
        operands.add(operand);
    }
}
