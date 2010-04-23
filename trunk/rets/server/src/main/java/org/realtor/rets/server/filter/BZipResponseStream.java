/*
 * CompressionResponseStream.java
 *
 * Created on September 24, 2002, 2:51 PM
 */
package org.realtor.rets.server.filter;

import com.aftexsw.util.bzip.CBZip2OutputStream;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/**
 * Implementation of <b>ServletOutputStream</b> that works with
 * the BZipServletResponseWrapper implementation.
 *
 */
public class BZipResponseStream extends ServletOutputStream {
    // ----------------------------------------------------- Instance Variables

    /**
     * The threshold number which decides to compress or not.
     * Users can configure in web.xml to set it to fit their needs.
     */
    protected int compressionThreshold = 0;

    /**
     * The buffer through which all of our output bytes are passed.
     */
    protected byte[] buffer = null;

    /**
     * Is it big enough to compress?
     */
    protected boolean compressionThresholdReached = false;

    /**
     * The number of data bytes currently in the buffer.
     */
    protected int bufferCount = 0;

    /**
     * The underlying bzip output stream to which we should write data.
     */
    protected CBZip2OutputStream bzipstream = null;

    /**
     * Has this stream been closed?
     */
    protected boolean closed = false;

    /**
     * The number of bytes which have already been written to this stream.
     */
    protected int count = 0;

    /**
     * The content length past which we will not write, or -1 if there is
     * no defined content length.
     */
    protected int length = -1;

    /**
     * The response with which this servlet output stream is associated.
     */
    protected HttpServletResponse response = null;

    /**
     * The underlying servket output stream to which we should write data.
     */
    protected ServletOutputStream output = null;

    // ----------------------------------------------------------- Constructors

    /**
     * Construct a servlet output stream associated with the specified Response.
     *
     * @param response The associated response
     */
    public BZipResponseStream(HttpServletResponse response)
        throws IOException {
        super();
        closed = false;
        count = 0;
        this.response = response;
        this.output = response.getOutputStream();
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Set the compressionThreshold number and create buffer for this size
     */
    protected void setBuffer(int threshold) {
        compressionThreshold = threshold;
        buffer = new byte[compressionThreshold];

        //System.out.println("buffer is set to "+compressionThreshold);
    }

    /**
     * Close this output stream, causing any buffered data to be flushed and
     * any further output data to throw an IOException.
     */
    public void close() throws IOException {
        //System.out.println("close() @ CompressionResponseStream");
        if (closed) {
            throw new IOException("This output stream has already been closed");
        }

        if (bzipstream != null) {
            flushToBZip();
            bzipstream.close();
        } else {
            if (bufferCount > 0) {
                output.write(buffer, 0, bufferCount);
                bufferCount = 0;
            }
        }

        output.close();
        closed = true;
    }

    /**
     * Flush any buffered data for this output stream, which also causes the
     * response to be committed.
     */
    public void flush() throws IOException {
        //System.out.println("flush() @ CompressionResponseStream");
        if (closed) {
            throw new IOException("Cannot flush a closed output stream");
        }

        if (bzipstream != null) {
            bzipstream.flush();
        }
    }

    public void flushToBZip() throws IOException {
        //System.out.println("flushToBZip() @ CompressionResponseStream");
        if (bufferCount > 0) {
            //System.out.println("flushing out to BZipStream");
            bzipstream.write(buffer, 0, bufferCount);
            bufferCount = 0;
        }
    }

    /**
     * Write the specified byte to our output stream.
     *
     * @param b The byte to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(int b) throws IOException {
        //System.out.print("write "+b+" in CompressionResponseStream ");
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }

        if ((bufferCount >= buffer.length) || (count >= compressionThreshold)) {
            compressionThresholdReached = true;
        }

        if (compressionThresholdReached) {
            writeToBZip(b);
        } else {
            buffer[bufferCount++] = (byte) b;
            count++;
        }
    }

    /**
     * Write the specified byte to our compressed BZip output stream.
     *
     * @param b The byte to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void writeToBZip(int b) throws IOException {
        //System.out.println("writeToBZip (int b) compressing");
        if (bzipstream == null) {
            bzipstream = new CBZip2OutputStream(output);
            response.addHeader("Content-Encoding", "bzip");
        }

        bzipstream.write(b);
    }

    /**
     * Write <code>b.length</code> bytes from the specified byte array
     * to our output stream.
     *
     * @param b The byte array to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    /**
     * Write <code>len</code> bytes from the specified byte array, starting
     * at the specified offset, to our output stream.
     *
     * @param b The byte array containing the bytes to be written
     * @param off Zero-relative starting offset of the bytes to be written
     * @param len The number of bytes to be written
     *
     * @exception IOException if an input/output error occurs
     */
    public void write(byte[] b, int off, int len) throws IOException {
        //System.out.println("second write in CompressionResponseStream");
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }

        if (len == 0) {
            return;
        }

        if (len <= (buffer.length - bufferCount)) {
            System.arraycopy(b, off, buffer, bufferCount, len);
            bufferCount += len;
            count += len;

            return;
        }

        // buffer full, start writing to bzipstream
        writeToBZip(b, off, len);
        count += len;
    }

    public void writeToBZip(byte[] b, int off, int len)
        throws IOException {
        //System.out.println("writeToBZip 2 compressing");
        if (bzipstream == null) {
            bzipstream = new CBZip2OutputStream(output);
            response.addHeader("Content-Encoding", "bzip");
        }

        bzipstream.write(b, off, len);
    }

    // -------------------------------------------------------- Package Methods

    /**
     * Has this response stream been closed?
     */
    public boolean closed() {
        return (this.closed);
    }

    /**
     * Reset the count of bytes written to this stream to zero.
     */
    public void reset() {
        count = 0;
    }
}
