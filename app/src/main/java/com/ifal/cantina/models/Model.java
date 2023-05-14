package com.ifal.cantina.models;

import com.ifal.cantina.annotations.DBField;
import com.ifal.cantina.annotations.DBTable;
import com.ifal.cantina.interfaces.IModel;
import com.ifal.cantina.utils.factorys.ConnectionFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a model in the application.
 *
 * @author Nicolas Albuquerque R.
 */
public class Model implements IModel {
    private Connection connection = null;
    private String statementSql;

    /**
     * Constructs a new instance of the IModel class.
     * Initializes the connection using the ConnectionFactory.
     */
    public Model() {
        this.connection = ConnectionFactory.createConnection();
    }

    @Override
    public void commit() throws SQLException {
        try (PreparedStatement statement = this.connection.prepareStatement(this.statementSql)) {
            statement.execute();
        }
    }

    @Override
    public IModel insert(Object entity) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityData = extractDataFromEntity(entity);
            this.statementSql = buildSqlForInsert(tableName, entityData);
        }

        return this;
    }

    @Override
    public IModel delete(Object entity) {
        return this;
    }

    @Override
    public IModel query(int id) {
        return this;
    }

    @Override
    public IModel update(Object entity) {
        return this;
    }

    /**
     * Extracts data from an entity object and returns it as a map of field names and values.
     *
     * @param entity the entity object to extract data from.
     * @return a map containing the extracted data.
     * @throws IllegalAccessException if there is illegal access to the fields of the entity object.
     */
    private Map<String, String> extractDataFromEntity(Object entity) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();

        return new HashMap<>() {
            {
                for (Field field : entityFields) {
                    field.setAccessible(true); // Pass the private attributes as visible.
                    DBField tableField = field.getAnnotation(DBField.class);

                    if (tableField != null) {
                        String fieldName = tableField.fieldName();

                        put(fieldName, field.get(entity).toString());
                    }
                }
            }
        };
    }

    /**
     * Builds the SQL statement for inserting data into a table.
     *
     * @param tableName  the name of the table.
     * @param dataEntity the data to be inserted, represented as a map of field names and values.
     * @return the SQL statement for the insertion.
     */
    private String buildSqlForInsert(String tableName, Map<String, String> dataEntity) {
        StringBuilder statementFields = new StringBuilder();
        StringBuilder statementValues = new StringBuilder();

        for (String entityField : dataEntity.keySet()) {
            if (!statementFields.toString().equals("")) statementFields.append(", ");

            if (!statementValues.toString().equals("")) statementValues.append(", ");

            String valueField = dataEntity.get(entityField);

            statementFields.append(String.format("%s", entityField));
            statementValues.append(String.format("'%s'", valueField));
        }

        return String.format("INSERT INTO %s (%s) VALUES(%s);",
                tableName, statementFields, statementValues);
    }
}
