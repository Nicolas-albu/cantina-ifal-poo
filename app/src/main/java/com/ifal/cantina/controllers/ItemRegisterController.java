package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

/**
 * Subclass of AController to control item registration.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 */
public class ItemRegisterController extends AController {

    /**
     * Constructs a new instance of the ItemRegisterController class.
     * Initializes the model and view using the parent class constructor.
     */
    public ItemRegisterController() {
        super();
    }
    
    @Override
    public void run() {
        Product product = (Product) super.getResultShowMenu();

        try {
            super.model.insert(product).commit();

        } catch (IllegalAccessException | SQLException error) {
            super.view.printException(error);
        }

        super.view.printResult();
        super.view.close();
    }
}
