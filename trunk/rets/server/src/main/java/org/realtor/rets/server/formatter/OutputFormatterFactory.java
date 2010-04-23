/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.formatter;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.velocity.app.Velocity;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OutputFormatterFactory {

    protected static Category cat = Category.getInstance(OutputFormatterFactory.class);

    private static HashMap registeredFormatters = new HashMap();
    
    static { init(); }
    
    public static void init() {
        try {
            Properties p = new Properties();
            p.setProperty("resource.loader", "class");
            p.setProperty("class.resource.loader.description", "");
            p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            Velocity.init( p );
        } catch (Exception e) {
            //unable to load init velocity -- warn developer
            cat.error(e);
        }
        registeredFormatters.put("STANDARD-XML", new VelocityTemplateFormatter());
        registeredFormatters.put("COMPACT", new CompactXmlFormatter());
        registeredFormatters.put("COMPACT-DECODED", new CompactXmlFormatter());
    }
    
    public static OutputFormatter createFormatter(String outputType, HashMap properties, String version) {

        OutputFormatter formatter = (OutputFormatter) registeredFormatters.get(outputType);

        String templateName = properties.get("Class") + version.replaceAll("\\.", "") +".vm";
        properties.put("templateName", templateName);
        return formatter;
    }
}
