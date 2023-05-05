package com.ifal.cantina.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory the connection to database.
 *
 * @author Nicolas
 */
public class ConnectionFactory {
    /**
     *
     * @return return the database connection.
     */
    public static Connection create() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    ConfigDatas.getUrlDatabase(),
                    ConfigDatas.getDbUser(),
                    ConfigDatas.getDbPassword());
        } catch (SQLException error) {
            System.err.println("Ocorreu um erro: ");
            error.printStackTrace();
        }

        return connection;
    }    
}
