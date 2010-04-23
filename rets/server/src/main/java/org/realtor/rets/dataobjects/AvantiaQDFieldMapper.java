/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/dataobjects/AvantiaQDFieldMapper.java,v 1.1.1.1 2003/11/21 16:20:24 rsegelman Exp $
 *
 *
 */
package org.realtor.rets.dataobjects;

import org.realtor.rets.persistence.SimpleJDBCConnectionPool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Field;

import java.sql.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;


/**
 *  AvantiaQDFieldMapper.java Created Jul 21, 2003
 *
 *
 *  Copyright 2003, Avantia inc.
 *  @version $Revision: 1.1.1.1 $
 *  @author scohen
 */
public class AvantiaQDFieldMapper {
    private Class toMap;
    private String outputFile;
    private String tableName;
    private BufferedReader input;
    private Vector objectFields;
    private Vector unmappedObjectFields;
    private Vector databaseFields;
    private String objectFieldString;
    private StringBuffer xmlFile;
    private Vector mappings;

    public AvantiaQDFieldMapper() {
        mappings = new Vector();
        input = new BufferedReader(new InputStreamReader(System.in));
        promptForClassName();
        promptForTableName();
        promptForOutputFile();
        getDatabaseFields();
        map();
        addPrimaryKeys();
        verifyMapping();
        generateXML();
        this.writeFile(xmlFile);
    }

    public void promptForClassName() {
        String className;
        System.out.println("Please enter fully qualified class name: ");

        try {
            className = input.readLine().trim();
            toMap = Class.forName(className);
            getObjectFields();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void promptForTableName() {
        System.out.println("Please enter table name: ");

        try {
            tableName = input.readLine().trim();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void promptForOutputFile() {
        System.out.println("Please enter output file: ");

        try {
            outputFile = input.readLine().trim();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void map() {
        for (int i = 0; i < databaseFields.size(); i++) {
            printObjectFields();

            DatabaseMetaData data = (DatabaseMetaData) databaseFields.elementAt(i);
            System.out.println("Database Column " + data.getColumnName() +
                " maps to");

            try {
                String line = input.readLine().trim();

                if (line.length() > 0) {
                    try {
                        int fieldID = Integer.parseInt(line);
                        mapField(fieldID, i);
                        unmappedObjectFields.remove(fieldID);
                    } catch (NumberFormatException e1) {
                        // allow non numbers, as this allows the user to skip
                        // the mapping of a field.
                    }
                } else {
                    break;
                }
            } catch (IOException e) {
                break;
            }
        }

        System.out.println("Mapping done.");
    }

    public void mapField(int fieldID, int databaseFieldNumber) {
        DatabaseMetaData data = (DatabaseMetaData) databaseFields.elementAt(databaseFieldNumber);
        Field objectMap = (Field) unmappedObjectFields.get(fieldID);
        Mapping m = new Mapping(data.getColumnName(), objectMap.getName(), data);
        mappings.add(m);
    }

    public void printObjectFields() {
        int columns = 5;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < unmappedObjectFields.size(); i += columns) {
            for (int j = i;
                    (j < (i + columns)) && (j < unmappedObjectFields.size());
                    j++) {
                Field current = (Field) unmappedObjectFields.elementAt(j);
                sb.append(j);
                sb.append(".) ");
                sb.append(current.getName());
                sb.append("\t\t");
            }

            sb.append("\n");
        }

        objectFieldString = sb.toString();

        System.out.println(objectFieldString);
    }

    private void generateXML() {
        xmlFile = new StringBuffer("<class-descriptor\n     class=\"");
        xmlFile.append(toMap.getName());
        xmlFile.append("\"\n     table=\"");
        xmlFile.append(tableName);
        xmlFile.append("\"\n>");

        for (int i = 0; i < mappings.size(); i++) {
            Mapping current = (Mapping) mappings.elementAt(i);
            DatabaseMetaData data = current.getMetaData();

            xmlFile.append("\n   <field-descriptor");
            xmlFile.append("\n      name=\"");
            xmlFile.append(current.getFieldName());
            xmlFile.append("\"");
            xmlFile.append("\n      column=\"");
            xmlFile.append(data.getColumnName());
            xmlFile.append("\"\n      ");
            xmlFile.append("jdbc-type=\"");
            xmlFile.append(data.getDataType());
            xmlFile.append("\"");

            if (current.isPrimaryKey()) {
                xmlFile.append("\n     primarykey=\"true\"");
            }

            if (current.isAutoIncrement()) {
                xmlFile.append("\n     autoincrement=\"true\"");
            }

            if (current.isAnonymous()) {
                xmlFile.append("\n     access=\"anonymous\"");
            }

            xmlFile.append("\n   />");
        }

        xmlFile.append("\n</class-descriptor>");
        System.out.println(xmlFile);

        //writeFile(file);
    }

    private void getObjectFields() {
        objectFields = new Vector();

        Field[] allFields = toMap.getDeclaredFields();

        for (int i = 0; i < allFields.length; i++) {
            Field current = allFields[i];
            objectFields.add(current);
        }

        Collections.sort(objectFields, new FieldComparator());
        unmappedObjectFields = (Vector) objectFields.clone();
    }

    /**
       *
       */
    private void verifyMapping() {
    }

    private void addPrimaryKeys() {
        System.out.println("Adding Primary Key:");

        for (int i = 0; i < databaseFields.size(); i++) {
            DatabaseMetaData data = (DatabaseMetaData) databaseFields.elementAt(i);
            System.out.println(i + ".) " + data.getColumnName());
        }

        System.out.println("Which field is your primary key? ");

        try {
            int columnNumber = Integer.parseInt(input.readLine());
            DatabaseMetaData data = (DatabaseMetaData) databaseFields.elementAt(columnNumber);
            String colName = data.getColumnName();

            // this should find the mapping.
            Mapping toFind = new Mapping(colName, "", null);
            int position = mappings.indexOf(toFind);

            Mapping pK;

            if (position < 0) {
                // we haven't mapped it... must be an anonymous field
                pK = new Mapping(colName, colName.toLowerCase(), data);
                pK.setPrimaryKey(true);
                pK.setAnonymous(true);
            } else {
                System.out.println("Found at position " + position);
                pK = (Mapping) mappings.remove(position);
            }

            System.out.println("Does it auto increment? ");

            String autoIncrement = input.readLine();

            if (autoIncrement.trim().toLowerCase().charAt(0) == 'y') {
                pK.setAutoIncrement(true);
            }

            pK.setPrimaryKey(true);
            mappings.add(0, pK);
        } catch (Exception e) {
        }
    }

    private void getDatabaseFields() {
        databaseFields = new Vector();

        Connection conn = SimpleJDBCConnectionPool.getConnection();

        try {
            Statement stmt = conn.createStatement();
            String query = "select * from " + tableName + " limit 1";
            ResultSet results = stmt.executeQuery(query);
            ResultSetMetaData metaData = results.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                databaseFields.add(new DatabaseMetaData(metaData, i));
            }

            Collections.sort(databaseFields, new ColumnComparator());

            results.close();
            stmt.close();
            conn.close();
        } catch (SQLException sql) {
        }
    }

    private void writeFile(StringBuffer fileContents) {
        try {
            FileOutputStream file = new FileOutputStream(outputFile);
            file.write(fileContents.toString().getBytes());
            file.flush();
            file.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AvantiaQDFieldMapper mapper = new AvantiaQDFieldMapper();
    }

    private class Mapping {
        private String columnName;
        private String fieldName;
        private DatabaseMetaData metaData;
        private boolean primaryKey;
        private boolean autoIncrement;
        private boolean anonymous;

        public Mapping(String colName, String fieldName,
            DatabaseMetaData metaData) {
            this.columnName = colName;
            this.fieldName = fieldName;
            this.metaData = metaData;
        }

        /**
         * @return
         */
        public boolean isAutoIncrement() {
            return autoIncrement;
        }

        /**
         * @return
         */
        public boolean isPrimaryKey() {
            return primaryKey;
        }

        /**
         * @param b
         */
        public void setAutoIncrement(boolean b) {
            autoIncrement = b;
        }

        /**
         * @param b
         */
        public void setPrimaryKey(boolean b) {
            primaryKey = b;
        }

        /**
         * @return
         */
        public DatabaseMetaData getMetaData() {
            return metaData;
        }

        public boolean equals(Object another) {
            if (another instanceof Mapping) {
                Mapping otherGuy = (Mapping) another;

                return (otherGuy.getColumnName().equals(columnName) ||
                otherGuy.getFieldName().equals(fieldName));
            }

            return false;
        }

        /**
         * @return
         */
        public String getColumnName() {
            return columnName;
        }

        /**
         * @return
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * @return
         */
        public boolean isAnonymous() {
            return anonymous;
        }

        /**
         * @param b
         */
        public void setAnonymous(boolean b) {
            anonymous = b;
        }
    }

    private class FieldComparator implements Comparator {
        /* (non-Javadoc)
        * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
        */
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Field && o2 instanceof Field) {
                Field f1;
                Field f2;
                f1 = (Field) o1;
                f2 = (Field) o2;

                return f1.getName().toLowerCase().compareTo(f2.getName()
                                                              .toLowerCase());
            }

            return 0;
        }
    }

    private class ColumnComparator implements Comparator {
        /* (non-Javadoc)
        * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
        */
        public int compare(Object o1, Object o2) {
            if (o1 instanceof DatabaseMetaData &&
                    o2 instanceof DatabaseMetaData) {
                DatabaseMetaData md1;
                DatabaseMetaData md2;
                md1 = (DatabaseMetaData) o1;
                md2 = (DatabaseMetaData) o2;

                return md1.getColumnName().toLowerCase().compareTo(md2.getColumnName()
                                                                      .toLowerCase());
            }

            return 0;
        }
    }

    private class DatabaseMetaData {
        private String dataType;
        private String columnName;

        public DatabaseMetaData(ResultSetMetaData metaData, int colNumber) {
            try {
                columnName = metaData.getColumnName(colNumber);
                dataType = this.mapColumnType(metaData.getColumnType(colNumber));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private String mapColumnType(int sqlType) {
            switch (sqlType) {
            case Types.DATE:
                return "DATE";

            case Types.TIME:
                return "TIME";

            case Types.TIMESTAMP:
                return "TIMESTAMP";

            case Types.BIGINT:
                return "INTEGER";

            case Types.INTEGER:
                return "INTEGER";

            case Types.DOUBLE:
                return "DOUBLE";

            case Types.LONGVARCHAR:
                return "LONGVARCHAR";

            case Types.TINYINT:
                return "TINYINT";

            case Types.SMALLINT:
                return "SMALLINT";

            case Types.FLOAT:
                return "FLOAT";

            default:
                return "VARCHAR";
            }
        }

        /**
         * @return
         */
        public String getColumnName() {
            return columnName;
        }

        /**
         * @return
         */
        public String getDataType() {
            return dataType;
        }
    }
}
