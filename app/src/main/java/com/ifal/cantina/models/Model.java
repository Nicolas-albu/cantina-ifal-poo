package com.ifal.cantina.models;

import com.ifal.cantina.annotations.Overload;
import com.ifal.cantina.annotations.DBTable;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.utils.Utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
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

    @Overload
    @Override
    public void commit() throws SQLException {
        try (PreparedStatement statement = super.connection.prepareStatement(this.statementSql)) {
            statement.execute();
        }
    }

    @Overload
    @Override
    public void commit(AView view) throws SQLException {
        try (PreparedStatement query = super.connection.prepareStatement(super.statementSql);
             ResultSet resultQuery = query.executeQuery()) {

            while (resultQuery.next()) {
                for (String columnName : super.columnNames) {
                    String columnValue = resultQuery.getString(columnName);

                    Utils.saveQueryFormat(columnValue, super.columnNames);
                }
                view.printQuery(Utils.getFormattedQuery());
            }
        }
    }

    @Override
    public AModel insert(Object entity) throws IllegalAccessException {
        DBTable dbTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (dbTableEntity != null) {
            String tableName = dbTableEntity.tableName();
            Map<String, String> entityData = super.extractDataFromEntity(entity);

            super.statementSql = super.buildSqlForInsert(tableName, entityData);
        }

        return this;
    }

    @Override
    public AModel delete(Object entity) throws IllegalAccessException {
        DBTable dbTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (dbTableEntity != null) {
            String tableName = dbTableEntity.tableName();
            Map<String, String> entityId = super.extractIdFromEntity(entity);

            super.statementSql = super.buildSqlForDelete(tableName, entityId);
        }

        return this;
    }
//
//    @Override
//    public AModel query(int id) {
//        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);
//
//        return this;
//    }

    @Override
    public AModel query(Class<?> entityClass, String orderBy) {
        DBTable dbTable = entityClass.getAnnotation(DBTable.class);

        if (dbTable != null) {
            String tableName = dbTable.tableName();
            List<String> tableColumnNames = super.extractTableColumnNames(entityClass);

            super.statementSql = super.buildSqlForQuery(tableName, tableColumnNames, orderBy);
        }

        return this;
    }

    @Override
    public AModel update(Object entity) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityId = super.extractIdFromEntity(entity);
            Map<String, String> entityData = super.extractDataFromEntityWithoutId(entity);

            super.statementSql = super.buildSqlForUpdate(tableName, entityId, entityData);
        }

        System.out.println(super.statementSql);

        return this;
    }
}
