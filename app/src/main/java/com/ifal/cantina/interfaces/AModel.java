package com.ifal.cantina.interfaces;

import java.sql.Connection;

import com.ifal.cantina.utils.factorys.ConnectionFactory;

/**
 * Abstract class representing a model in the application.
 * This class provides implementation for inserting, updating, deleting and querying data in the model's datastore.
 *
 * @author Nicolas Albuquerque R.
 */
public abstract class AModel {
    protected Connection connection;

    /**
     * Constructs a new instance of the AModel class.
     * Initializes the connection using the ConnectionFactory.
     */
    public AModel() {
        this.connection = ConnectionFactory.createConnection();
    }

    /**
     * Inserts an object into the data storage.
     *
     * @param object the object to be inserted
     */
    public abstract void insert(Object object);

    // /**
    //  * Deletes an object from the data storage.
    //  *
    //  * @param object the object to be deleted
    //  */
    // public abstract void delete(Object object);

    // /**
    //  * Queries data from the storage based on an ID and updates the AModel instance.
    //  *
    //  * @param id    the ID to query
    //  * @param model the AModel instance to update
    //  */
    // public abstract void query(int id, AModel model);

    // /**
    //  * Updates an object in the data storage.
    //  *
    //  * @param object the object to be updated
    //  */
    // public abstract void update(Object object);
}
