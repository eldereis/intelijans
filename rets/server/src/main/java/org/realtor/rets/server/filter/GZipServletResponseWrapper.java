/*
 * CompressionServletResponseWrapper.java
 *
 * Created on September 24, 2002, 2:49 PM
 */
package org.realtor.rets.server.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


/**
 * Implementation of <b>HttpServletResponseWrapper</b> that works with
 * the CompressionServletResponseStream implementation..
 *
 * @author Amy Roh
 * @version $Revision: 1.1.1.1 $, $Date: 2003/11/21 16:20:24 $
 */
public class GZipServletResponseWrapper extends HttpServletResponseWrapper {
    /**
     * Descriptive information about this Response implementation.
     */
    protected static final String info = "CompressionServletResponseWrapper";

    // ----------------------------------------------------- Instance Variables

    /**
     * Original response
     */
    protected HttpServletResponse origResponse = null;

    /**
     * The ServletOutputStream that has been returned by
     * <code>getOutputStream()</code>, if any.
     */
    protected ServletOutputStream stream = null;

    /**
     * The PrintWriter that has been returned by
     * <code>getWriter()</code>, if any.
     */
    protected PrintWriter writer = null;

    /**
     * The threshold number to compress
     */
    protected int threshold = 0;

    // ----------------------------------------------------- Constructor

    /**
     * Calls the parent constructor which creates a ServletResponse adaptor
     * wrapping the given response object.
     */
    public GZipServletResponseWrapper(HttpServletResponse response) {
        super(response);
        origResponse = response;

        //System.out.println("CompressionServletResponseWrapper constructor gets called");
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Set threshold number
     */
    public void setCompressionThreshold(int threshold) {
        //System.out.println("setCompressionThreshold @ CompressionServletResponseWrapper");
        this.threshold = threshold;
    }

    /**
     * Create and return a ServletOutputStream to write the content
     * associated with this Response.
     *
     * @exception IOException if an input/output error occurs
     */
    public ServletOutputStream createOutputStream() throws IOException {
        //System.out.println("createOutputStream gets called");
        return (new GZipResponseStream(origResponse));
    }

    /**
     * Finish a response.
     */
    public void finishResponse() {
        try {
            if (writer != null) {
                writer.close();
            } else {
                if (stream != null) {
                    stream.close();
                }
            }
        } catch (IOException e) {
        }
    }

    // ------------------------------------------------ ServletResponse Methods

    /**
     * Flush the buffer and commit this response.
     *
     * @exception IOException if an input/output error occurs
     */
    public void flushBuffer() throws IOException {
        //  System.out.println("flush buffer @ CompressionServletResponseWrapper");
        ((GZipResponseStream) stream).flush();
    }

    /**
     * Return the servlet output stream associated with this Response.
     *
     * @exception IllegalStateException if <code>getWriter</code> has
     *  already been called for this response
     * @exception IOException if an input/output error occurs
     */
    public ServletOutputStream getOutputStream() throws IOException {
        if (writer != null) {
            throw new IllegalStateException(
                "getWriter() has already been called for this response");
        }

        if (stream == null) {
            stream = createOutputStream();
        }

        //System.out.println("stream is set to "+stream+" in getOutputStream");
        ((GZipResponseStream) stream).setBuffer(threshold);

        return (stream);
    }

    /**
     * Return the writer associated with this Response.
     *
     * @exception IllegalStateException if <code>getOutputStream</code> has
     *  already been called for this response
     * @exception IOException if an input/output error occurs
     */
    public PrintWriter getWriter() throws IOException {
        if (writer != null) {
            return (writer);
        }

        if (stream != null) {
            throw new IllegalStateException(
                "getOutputStream() has already been called for this response");
        }

        stream = createOutputStream();

        //System.out.println("strean is set to "+stream+" in getWriter");
        ((GZipResponseStream) stream).setBuffer(threshold);
        writer = new PrintWriter(stream);

        return (writer);
    }

    public void setContentLength(int length) {
    }
}
