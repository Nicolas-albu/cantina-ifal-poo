/*
 * This Java source file contains the class that makes database connections.
 */
package com.ifal.cantina.utils.factorys;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.ifal.cantina.utils.ReadProperties;

import java.sql.Connection;

/**
 * Factory the connection to database.
 * 
 * @author Nicolas Albuquerque R.
 */
public class ConnectionFactory {
    
    /**
     * @return return the database connection.
     */
    public static Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                ReadProperties.getUrlConnection(),
                ReadProperties.getProperty("db.username"),
                ReadProperties.getProperty("db.password"));
        } catch (SQLException error) {
            System.err.format("Ocorreu um erro: %s\n", error.getMessage());
        }

        return connection;
    }    
}
