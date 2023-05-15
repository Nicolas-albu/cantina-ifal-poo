package com.ifal.cantina.interfaces;

import com.ifal.cantina.utils.factorys.ConnectionFactory;
import com.ifal.cantina.annotations.DBField;
import com.ifal.cantina.annotations.Id;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * The abstract class representing a model in the application.
 * This abstract class provides methods for manipulating data in the model's data storage.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 * @see AView
 */
public abstract class AModel {
    protected Connection connection;
    protected String statementSql;

    /**
     * Constructs a new instance of the AModel class.
     * Initializes the connection using the ConnectionFactory.
     */
    public AModel() {
        this.connection = ConnectionFactory.createConnection();
    }

    /**
     * Commits the changes made to the data storage.
     */
    public abstract void commit() throws SQLException;

    /**
     * Inserts an entity into the data storage.
     *
     * @param entity the entity to be inserted.
     */
    public abstract AModel insert(Object entity) throws IllegalAccessException;

    /**
     * Deletes an object from the data storage.
     *
     * @param entity the entity to be deleted.
     */
    public abstract AModel delete(Object entity) throws IllegalAccessException;

    /**
     * Queries data from the storage based on an ID.
     *
     * @param id the ID to query.
     */
    public abstract AModel query(int id);

    /**
     * Updates an object in the data storage.
     *
     * @param entity the entity to be updated.
     */
    public abstract AModel update(Object entity);

    /**
     * Extracts data from an entity object and returns it as a map of field names and values.
     *
     * @param entity the entity object to extract data from.
     * @return a map containing the extracted data.
     * @throws IllegalAccessException if there is illegal access to the fields of the entity object.
     */
    protected Map<String, String> extractDataFromEntity(Object entity) throws IllegalAccessException {
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
    protected Map<String, String> extractIdFromEntity(Object entity) throws IllegalAccessException {
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
    protected String buildSqlForInsert(String tableName, Map<String, String> dataEntity) {
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
    protected String buildSqlForDelete(String tableName, Map<String, String> entityId) {
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