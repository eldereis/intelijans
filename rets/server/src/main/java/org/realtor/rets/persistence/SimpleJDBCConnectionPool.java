/*
 * SimpleJDBCConnectionPool.java
 *
 * Created on September 27, 2002, 12:46 PM
 */
package org.realtor.rets.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Stack;

import org.realtor.rets.util.PropertiesLocator;


/**
 *
 * @author  tweber
 * @version
 *  Brain dead way of implementing connection pooling.
 */
public class SimpleJDBCConnectionPool {
    /** Creates new BrainDeadConnectionPool */
    private static Stack connections = null;
    private static final int NUM_CONNECTIONS = 4;
    static Properties props;
    private static int totalConnections = 0;
    private static java.util.Date lastAccess = null;
    private static long CONNECTIONTIMEOUT = 7200000L;
    private static final SimpleJDBCConnectionPool INSTANCE = new SimpleJDBCConnectionPool();

    // after this amount of time passes, reload connections
    public SimpleJDBCConnectionPool() {
        try {
            getDBConnections();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getDBConnections() {
        connections = new Stack();
        lastAccess = new java.util.Date();

        try {
            props = PropertiesLocator.locateProperties(
                    "RETSDBConnection.properties");
            Class.forName(props.getProperty("rets.DATABASE_DRIVER"))
                 .newInstance();

            for (int i = 0; i < NUM_CONNECTIONS; i++) {
                connections.push(DriverManager.getConnection(props.getProperty(
                            "rets.DATABASE_URL"),
                        props.getProperty("rets.USERNAME"),
                        props.getProperty("rets.PASSWORD")));
                totalConnections++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SimpleJDBCConnectionPool getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        if (connections == null) {
            getDBConnections();
        }

        java.util.Date currTime = new java.util.Date();

        if ((currTime.getTime() - lastAccess.getTime()) > CONNECTIONTIMEOUT) {
            System.out.println("Reloading Conection pool");
            shutdown();
            getDBConnections();
        } else {
            lastAccess = currTime;
        }

        if (connections.size() < 1) {
            try {
                totalConnections++;
                System.out.println("Total Number of SimpleJDBC Connections :" +
                    totalConnections);

                return (DriverManager.getConnection(props.getProperty(
                        "rets.DATABASE_URL"), "rets", "rets"));
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        } else {
            return (Connection) connections.pop();
        }
    }

    public void release(Connection conn) {
        connections.push(conn);
    }

    public static void shutdown() {
        while (!connections.empty()) {
            Connection conn = (Connection) connections.pop();

            //System.out.println("Shutting down connection.");
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Connection must have timed out");
            }
        }
    }
}
