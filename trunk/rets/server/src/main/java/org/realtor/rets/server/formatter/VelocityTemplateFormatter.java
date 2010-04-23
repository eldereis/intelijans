/*
 * Created on Jan 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.formatter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.realtor.rets.persistence.SearchResults;

import org.apache.log4j.Category;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VelocityTemplateFormatter implements OutputFormatter {

    /* (non-Javadoc)
     * @see org.realtor.rets.server.formatter.OutputFormatter#output(org.realtor.rets.persistence.SearchResults, java.util.Map, java.io.Writer)
     */
     static Category cat = Category.getInstance(VelocityTemplateFormatter.class);

    public void output(SearchResults results, Map parameters, Writer outputBuffer, int namespace) throws IOException {
        VelocityContext context = new VelocityContext();
        Template template = null;
        String templateName = (String) parameters.get("templateName");
        StringWriter sw = new StringWriter();

        context.put("results", results);
        context.put("parameters", parameters);
        context.put("esc", new EscapeTool());
        try {
           template = Velocity.getTemplate(templateName);
           template.merge(context, sw);
        } catch (ResourceNotFoundException rnfe) {
           sw.write(createErrorResponse("20203","Resource Not Found:Unable To complete your search request."));
           cat.error(rnfe);
        } catch (ParseErrorException pee) {
            sw.write(createErrorResponse("20203","Parse Error:Unable To complete your search request."));
            cat.error(pee);
        } catch (MethodInvocationException mie) {
            sw.write(createErrorResponse("20203","Method Invocation Error:Unable To complete your search request."));
            cat.error(mie);
        } catch (Exception e) {
            sw.write(createErrorResponse("20203","Exception:Unable To complete your search request."));
            cat.error(e);
        }

        outputBuffer.write(sw.toString());
    }

    private String createErrorResponse(String errorCode, String errorText) {
        StringBuffer errorResponse = new StringBuffer();

        errorResponse.append("<?xml version=\"1.0\" standalone=\"no\"?>\r\n");
        errorResponse.append(StandardXmlFormatter.DOCTYPE + "\r\n");
        errorResponse.append("<RETS ReplyCode=\"");
        errorResponse.append(errorCode);
        errorResponse.append("\" ReplyText=\"");
        errorResponse.append(errorText);
        errorResponse.append("\"");
        errorResponse.append(" />\r\n");

        return errorResponse.toString();
    }
}
