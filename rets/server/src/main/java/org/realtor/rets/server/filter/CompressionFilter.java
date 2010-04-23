/*
 * CompressionFilter.java
 *
 * Created on September 24, 2002, 2:12 PM
 *This class and the other classes in this package are adapted from filter examples
 *On the java.sun.com web site.
 */
package org.realtor.rets.server.filter;

import java.io.*;

import java.net.*;

import java.text.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;


/**
 *
 * @author  tweber
 * @version
 */
public class CompressionFilter implements Filter {
    private static boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured.
    private FilterConfig config = null;

    /**
     * The threshold number to compress
     */
    protected int compressionThreshold;

    /**
     * Debug level for this filter
     */
    public CompressionFilter() {
    }

    private void doBeforeProcessing(ServletRequest request,
        ServletResponse response) throws IOException, ServletException {
        if (debug) {
            log("CompressionFilter:DoBeforeProcessing");
        }

        //
        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        //
    }

    /**
     * Take this filter out of service.
     */
    public void destroy() {
        this.config = null;
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param result The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        if (debug) {
            System.out.println("@doFilter");
        }

        boolean supportGzip = false;
        boolean supportBzip = false;

        if (request instanceof HttpServletRequest) {
            Enumeration e = ((HttpServletRequest) request).getHeaders(
                    "Accept-Encoding");

            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();

                if (name.indexOf("gzip") != -1) {
                    if (debug) {
                        System.out.println("supports compression");
                    }

                    supportGzip = true;
                } else if (name.indexOf("bzip") != -1) {
                    if (debug) {
                        System.out.println("supports compression");
                    }

                    supportBzip = true;
                } else {
                    if (debug) {
                        System.out.println("no suuport for compresion");
                    }
                }
            }
        }

        if (supportGzip) {
            if (response instanceof HttpServletResponse) {
                GZipServletResponseWrapper wrappedResponse = new GZipServletResponseWrapper((HttpServletResponse) response);
                wrappedResponse.setCompressionThreshold(compressionThreshold);

                if (debug) {
                    System.out.println("doFilter gets called with compression");
                }

                try {
                    chain.doFilter(request, wrappedResponse);
                } finally {
                    wrappedResponse.finishResponse();
                }

                return;
            }
        } else if (supportBzip) {
            if (response instanceof HttpServletResponse) {
                BZipServletResponseWrapper wrappedResponse = new BZipServletResponseWrapper((HttpServletResponse) response);
                wrappedResponse.setCompressionThreshold(compressionThreshold);

                if (debug) {
                    System.out.println("doFilter gets called with compression");
                }

                try {
                    chain.doFilter(request, wrappedResponse);
                } finally {
                    wrappedResponse.finishResponse();
                }

                return;
            }
        } else {
            if (debug) {
                System.out.println("doFilter gets called wo compression");
            }

            chain.doFilter(request, response);

            return;
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.config);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.config = filterConfig;
    }

    /**
     * Init method for this filter
     *
     */
    public void init(FilterConfig filterConfig) {
        config = filterConfig;

        if (filterConfig != null) {
            String str = filterConfig.getInitParameter("compressionThreshold");

            if (str != null) {
                compressionThreshold = Integer.parseInt(str);
            } else {
                compressionThreshold = 0;
            }

            String value = filterConfig.getInitParameter("debug");

            if (value != null) {
                if (value.equals("0")) {
                    debug = true;
                }
            } else {
                debug = false;
            }
        } else {
            compressionThreshold = 0;
        }
    }

    /**
     * Return a String representation of this object.
     */
    public String toString() {
        if (config == null) {
            return ("CompressionFilter()");
        }

        StringBuffer sb = new StringBuffer("CompressionFilter(");
        sb.append(config);
        sb.append(")");

        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if ((stackTrace != null) && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");

                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print(
                    "<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
                ;
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
                ;
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;

        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }

        return stackTrace;
    }

    public void log(String msg) {
        config.getServletContext().log(msg);
    }
}
