package com.ifal.cantina.model;

import java.sql.Connection;

import com.ifal.cantina.interfaces.IModel;

public class Model implements IModel {
    private Connection connection = null;

    public Model(Connection connection) {
        this.connection = connection;
    }
}
