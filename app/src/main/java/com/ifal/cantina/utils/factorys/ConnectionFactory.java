/*
 * This Java source file contains the class that makes database connections.
 */
package com.ifal.cantina.utils.factorys;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.utils.Utils;

/**
 * Pattern Factory the connection to database.
 * 
 * @author Nicolas Albuquerque R.
 */
public class ConnectionFactory {
    
    /**
     * @return the database connection.
     */
    public static Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                ReadProperties.getUrlConnection(),
                ReadProperties.getProperty("db.username"),
                ReadProperties.getProperty("db.password"));

        } catch (SQLException error) {
            System.out.println(Utils
                    .coloredExceptionMessage("Ocorreu um erro: %s%n", error.getMessage()));
        }

        return connection;
    }    
}
