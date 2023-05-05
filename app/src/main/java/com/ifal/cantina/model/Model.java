package com.ifal.cantina.model;

import java.sql.Connection;

public class Model {
    private Connection connection = null;

    public Model(String urlConnection, String user, String password) {

    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
