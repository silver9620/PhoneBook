/*
 * Copyright (c) 2015 Silver.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Silver - initial API and implementation and/or initial documentation
 */
package phonebook.connections;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silver
 */
public class dbconn {
    
    public dbconn()
    {
        createConnection();
    }
    
    /**
     * Database URL
     */
    private final String dbURL = "jdbc:derby:Phonebook;create=true;user=pb;password=silverstudios";

    private final String userTable = "USERN";
    private final String pbTable = "PHONEBOOKPB";

    //JDBC Connections
    Connection conn = null;
    Statement stmt = null;


    /**
     * Creates a connection to the database using the dbURL.
     */
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Create the Connection
            conn = DriverManager.getConnection(dbURL);
            createTables();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Checks to make sure both tables are accounted for. If not it creates
     * them.
     */
    private void createTables() {
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "usern".toUpperCase(), null);
            if (rs.next()) {
                System.out.println("Table " + rs.getString("TABLE_NAME") + " exists!!");
            } else {
                System.out.println("Creating User Table....");
                createUsern();
            }

            rs = dbmd.getTables(null, null, "phonebookpb".toUpperCase(), null);
            if (rs.next()) {
                System.out.println("Table " + rs.getString("TABLE_NAME") + " exists!!");
            } else {
                System.out.println("Creating Phonebook Table....");
                createPhonebookpb();
            }
            //return true;
        } catch (SQLException ex) {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createUsern() {
        try {
            stmt = conn.createStatement();
            String SQLU = "CREATE TABLE USERN (\n"
                    + "  userNa VARCHAR(50) NOT NULL,\n"
                    + "  passwd VARCHAR(200) NOT NULL)";
            stmt.execute(SQLU);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createPhonebookpb() {
        try {
            stmt = conn.createStatement();
            String SQLPB = "CREATE TABLE PHONEBOOKPB (  Name VARCHAR(200) NOT NULL, Address VARCHAR(200),\n"
                    + "State VARCHAR(50) ,\n"
                    + "City VARCHAR(45), Zipcode INT,\n"
                    + "PhoneNum VARCHAR(45), USERN VARCHAR(200) NOT NULL)";
            stmt.execute(SQLPB);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTables();
    }
    
}
