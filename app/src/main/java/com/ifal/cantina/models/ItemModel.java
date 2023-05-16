package com.ifal.cantina.models;

import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.interfaces.AView;

import java.sql.SQLException;

public class ItemModel extends AModel {

    public ItemModel() {
        super();
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void commit(AView view) throws SQLException {

    }

    @Override
    public Object commitWithReturn(String columnName) throws SQLException {
        return null;
    }

    @Override
    public AModel insert(Object entity) throws IllegalAccessException {
        return null;
    }

    @Override
    public AModel delete(Object entity) throws IllegalAccessException {
        return null;
    }

    @Override
    public AModel query(int id, Class<?> entityClass, String columnName) {
        return null;
    }

    @Override
    public AModel query(Class<?> entityClass, String orderBy) {
        return null;
    }

    @Override
    public AModel query(Class<?> entityClass, String limitedField, int limit) {
        return null;
    }

    @Override
    public AModel update(Object entity) throws IllegalAccessException {
        return null;
    }

    @Override
    public AModel update(Object entity, String columnName) throws IllegalAccessException {
        return null;
    }
}
