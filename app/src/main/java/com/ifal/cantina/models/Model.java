package com.ifal.cantina.models;

import com.ifal.cantina.utils.factorys.ConnectionFactory;
import com.ifal.cantina.annotations.DBField;
import com.ifal.cantina.annotations.DBTable;
import com.ifal.cantina.interfaces.IModel;
import com.ifal.cantina.annotations.Id;

import java.sql.PreparedStatement;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a model in the application.
 *
 * @author Nicolas Albuquerque R.
 * @see IModel
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
    public IModel delete(Object entity) throws IllegalAccessException {
        DBTable DBTableEntity = entity.getClass().getAnnotation(DBTable.class);

        if (DBTableEntity != null) {
            String tableName = DBTableEntity.tableName();
            Map<String, String> entityId = extractIdFromEntity(entity);

            this.statementSql = buildSqlForDelete(tableName, entityId);
        }

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
     * <p> Extracts the ID field from an entity object and returns it as a map with the ID name and
     * value.</p>
     *
     * @param entity the entity object to extract the ID from.
     * @return a map containing the ID field name and value.
     * @throws IllegalAccessException if there is illegal access to the fields of the entity object.
     */
    private Map<String, String> extractIdFromEntity(Object entity) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();

        return new HashMap<>() {
            {
                for (Field field : entityFields) {
                    field.setAccessible(true);
                    Id tableId = field.getAnnotation(Id.class);
                    DBField tableField = field.getAnnotation(DBField.class);

                    if (tableId != null) {
                        String idName = tableId
                                .idName().equals("") ? tableField.fieldName() : tableId.idName();

                        put(idName, field.get(entity).toString());
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
        String valueField;

        for (String entityField : dataEntity.keySet()) {
            if (!statementFields.toString().equals("")) statementFields.append(", ");
            if (!statementValues.toString().equals("")) statementValues.append(", ");

            valueField = dataEntity.get(entityField);

            statementFields.append(entityField);
            statementValues.append(String.format("'%s'", valueField));
        }

        return String.format("INSERT INTO %s (%s) VALUES(%s);",
                tableName, statementFields, statementValues);
    }

    /**
     * Builds the SQL statement for deleting data from a table based on the provided ID.
     *
     * @param tableName the name of the table.
     * @param entityId  <p> the ID of the entity to be deleted, represented as a map with the ID name
     *                  and value.</p>
     * @return the SQL statement for the deletion.
     */
    private String buildSqlForDelete(String tableName, Map<String, String> entityId) {
        StringBuilder idValueStatement = new StringBuilder();
        String entityIdNameStatement = null;
        String idValue;

        for (String entityIdName : entityId.keySet()) {
            entityIdNameStatement = entityIdName;
            idValue = entityId.get(entityIdName);

            idValueStatement.append(String.format("'%s'", idValue));
        }

        return String.format("DELETE FROM %s WHERE %s = %s;", tableName,
                entityIdNameStatement, idValueStatement);
    }
}
