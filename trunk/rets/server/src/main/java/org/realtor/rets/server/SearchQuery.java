/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server;

import java.util.ArrayList;
import java.util.List;

import org.realtor.rets.server.decoder.Expression;
import org.realtor.rets.server.decoder.TableDescription;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchQuery {

    private Expression queryExpression = null;
    private List fieldsToRetrieve = new ArrayList();
    private TableDescription tableDescription = null;

    /**
     * @return Returns the fieldsToRetrieve.
     */
    public List getFieldsToRetrieve() {
        return fieldsToRetrieve;
    }
    /**
     * @return Returns the queryExpression.
     */
    public Expression getQueryExpression() {
        return queryExpression;
    }
    /**
     * @param fieldsToRetrieve The fieldsToRetrieve to set.
     */
    public void setFieldsToRetrieve(List fieldsToRetrieve) {
        this.fieldsToRetrieve = fieldsToRetrieve;
    }
    /**
     * @param queryExpression The queryExpression to set.
     */
    public void setQueryExpression(Expression queryExpression) {
        this.queryExpression = queryExpression;
    }

    public TableDescription getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
    }
}
