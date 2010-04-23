// $Header: /usr/local/cvsroot/rets/clientapp/src/main/java/org/realtor/rets/monitor/RETSMonitor.java,v 1.1.1.1 2003/11/21 16:19:37 rsegelman Exp $
package org.realtor.rets.monitor;

import org.apache.log4j.Category;

//import javax.servlet.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** RETSMonitor provides a window into the communications between a rets client
 *  and Server. This utility is for demonstrations and debugging.
 *
 *  @author jbrush
 *  @version 1.0
 */
public class RETSMonitor extends HttpServlet {
    static Category cat = Category.getInstance(RETSMonitor.class);
    String fileName = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String uri = request.getRequestURI();
        String target = uri.substring(uri.lastIndexOf('/') + 1);
        cat.info("Monitoring: " + target);

        fileName = "/tmp/rets" + target + ".log";

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html><head><title>Monitoring: ");
        out.print(target);
        out.println("</title></head><body><xmp>");

        tail(out);

        out.println("</xmp></body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        doGet(request, response);
    }

    public void tail(PrintWriter out) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            char[] charArray = new char[32 * 1024];
            int numCharsRead;

            while (true) {
                numCharsRead = bufferedReader.read(charArray, 0,
                        charArray.length);

                if (numCharsRead > 0) {
                    out.print(new String(charArray, 0, numCharsRead));
                }

                if (numCharsRead < charArray.length) {
                    out.flush();

                    try {
                        Thread.sleep(1); // 1 second
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            cat.error("Monitor Exception", e);
            out.println("Unable to display: " + fileName);
        }
    }
}
