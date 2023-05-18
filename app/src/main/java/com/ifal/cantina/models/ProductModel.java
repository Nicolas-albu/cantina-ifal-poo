package com.ifal.cantina.models;

import com.ifal.cantina.annotations.Overload;
import com.ifal.cantina.annotations.DBTable;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.utils.QueryTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class representing a model in the application.
 *
 * @author Nicolas Albuquerque R.
 * @see AModel
 */
public class ProductModel extends AModel {

    /**
     * Constructs a new instance of the AModel class.
     * Initializes the connection using the ConnectionFactory.
     */
    public ProductModel() {
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

            QueryTable table = new QueryTable(columnNames);
            List<String> columnValues = new ArrayList<>();

            while (resultQuery.next()) {
                columnValues.clear();

                for (String columnName : super.columnNames) {
                    columnValues.add(resultQuery.getString(columnName));
                }

                table.saveQueryFormat(columnValues);
            }
            view.printQuery(table.toString());
        }
    }

    @Override
    public Object commitWithReturn(String columnName) throws SQLException {
        Integer output = null;

        try (PreparedStatement query = super.connection.prepareStatement(super.statementSql);
             ResultSet resultQuery = query.executeQuery()) {

            while (resultQuery.next()) {
                 output = resultQuery.getInt(columnName);
            }
        }

        return output;
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

    @Overload
    @Override
    public AModel query(int id, Class<?> entityClass, String columnName) {
        DBTable dbTable = entityClass.getAnnotation(DBTable.class);

        if (dbTable != null) {
            String idName = super.extractIdNameFromEntityClass(entityClass);
            String tableName = dbTable.tableName();

            super.statementSql = super.buildSqlForQuery(id, idName, tableName, columnName);
        }

        return this;
    }

    @Overload
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

    @Overload
    @Override
    public  AModel query(Class<?> entityClass, String limitedField, int limit) {
        DBTable dbTable = entityClass.getAnnotation(DBTable.class);

        if (dbTable != null) {
            String tableName = dbTable.tableName();
            List<String> tableColumnNames = super.extractTableColumnNames(entityClass);

            super.statementSql = super.buildSqlForQuery(tableName, tableColumnNames, limitedField, limit);
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

        return this;
    }

    @Override
    public AModel update(Object entity, String columnName) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityId = super.extractIdFromEntity(entity);
            Map<String, String> entityData = super.extractDataFromAnEntityColumn(entity, columnName);

            super.statementSql = super.buildSqlForUpdate(tableName, entityId, entityData);
        }

        return this;
    }
}
