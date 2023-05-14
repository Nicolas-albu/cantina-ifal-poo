package com.ifal.cantina.controllers;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

/**
 * Subclass of AController to control item registration.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 */
public class RegisterItemController extends AController {

    /**
     * Constructs a new instance of the RegisterItemController class.
     * Initializes the model and view using the parent class constructor.
     */
    public RegisterItemController() {
        super();
    }
    
    @Override
    public void run() {
        Product product = this.getProduct();

        try {
            super.model.insert(product).commit();

        } catch (IllegalAccessException | SQLException error) {
            super.view.printException(error);
        }

        super.view.printResult();
        super.view.close();
    }

    /**
     * Returns the obtained Product object by invoking the view's show() method.
     *
     * @return The Product object obtained from the view or null in case of an exception.
     */
    private Product getProduct() {
        Product product = null;

        try {
            product = (Product) super.view.show();

        } catch (EntityException error) {
            super.view.printException(error);
        }

        return product;
    }
}
