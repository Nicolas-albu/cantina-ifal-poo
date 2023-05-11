package com.ifal.cantina.interfaces;

import java.sql.Connection;

import com.ifal.cantina.utils.factorys.ConnectionFactory;

public abstract class AModel {
    public Connection connection;
    
    public AModel() {
        this.connection = ConnectionFactory.createConnection();
    }

    public abstract Object add(Object object);
}
