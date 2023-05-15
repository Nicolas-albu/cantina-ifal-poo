package com.ifal.cantina.models;

import com.ifal.cantina.annotations.DBTable;
import com.ifal.cantina.interfaces.AModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Class representing a model in the application.
 *
 * @author Nicolas Albuquerque R.
 * @see AModel
 */
public class Model extends AModel {

    /**
     * Constructs a new instance of the AModel class.
     * Initializes the connection using the ConnectionFactory.
     */
    public Model() {
        super();
    }

    @Override
    public void commit() throws SQLException {
        try (PreparedStatement statement = super.connection.prepareStatement(this.statementSql)) {
            statement.execute();
        }
    }

    @Override
    public AModel insert(Object entity) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityData = super.extractDataFromEntity(entity);

            super.statementSql = super.buildSqlForInsert(tableName, entityData);
        }

        return this;
    }

    @Override
    public AModel delete(Object entity) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityId = super.extractIdFromEntity(entity);

            super.statementSql = super.buildSqlForDelete(tableName, entityId);
        }

        return this;
    }

    @Override
    public AModel query(int id) {
        return this;
    }

    @Override
    public AModel update(Object entity) {
        return this;
    }
}
