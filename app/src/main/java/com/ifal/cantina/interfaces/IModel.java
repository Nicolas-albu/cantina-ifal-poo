package com.ifal.cantina.interfaces;

import java.sql.SQLException;

/**
 * The interface representing a model in the application.
 * This interface provides methods for manipulating data in the model's data storage.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 * @see AView
 */
public interface IModel {

    /**
     * Commits the changes made to the data storage.
     */
    void commit() throws SQLException;

    /**
     * Inserts an entity into the data storage.
     *
     * @param entity the entity to be inserted.
     */
    IModel insert(Object entity) throws IllegalAccessException;

    /**
     * Deletes an object from the data storage.
     *
     * @param entity the entity to be deleted.
     */
    IModel delete(Object entity) throws IllegalAccessException;

    /**
     * Queries data from the storage based on an ID.
     *
     * @param id the ID to query.
     */
    IModel query(int id);

    /**
     * Updates an object in the data storage.
     *
     * @param entity the entity to be updated.
     */
    IModel update(Object entity);
}