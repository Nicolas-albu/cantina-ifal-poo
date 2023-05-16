package com.ifal.cantina.controllers;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

/**
 * <p> The ItemRemovalController class is a subclass of AController that handles the removal of a
 *     product item.</p>
 * <p> It interacts with the model and view components to execute the removal logic.</p>
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 */
public class ItemRemovalController extends AController {

    /**
     * Constructs a new instance of the ItemRemovalController class.
     * Initializes the model and view using the parent class constructor.
     */
    public ItemRemovalController() {
        super();
    }

    @Override
    public void run() {
        Product product = (Product) super.getResultShowMenu();

        try {
            super.model.delete(product).commit();

        } catch (IllegalAccessException | SQLException error) {
            super.view.printException(error);
        }

        super.view.printResult();
        super.view.close();
    }
}
