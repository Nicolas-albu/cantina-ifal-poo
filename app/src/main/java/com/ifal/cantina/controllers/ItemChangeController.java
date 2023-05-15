package com.ifal.cantina.controllers;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

/**
 * <p> The ItemChangeController class is responsible for handling the logic of changing an item in
 * the system.</p>
 * This class extends the AController abstract class.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 */
public class ItemChangeController extends AController {

    /**
     * Constructs an instance of ItemChangeController.
     * Calls the superclass constructor.
     */
    public ItemChangeController() {
        super();
    }

    @Override
    public void run() {
        Product product = this.getProduct();

        try {
            super.model.update(product).commit();

        } catch (IllegalAccessException | SQLException error) {
            super.view.printException(error);
        }

        super.view.printResult();
        super.view.close();
    }

    /**
     * Retrieves the modified product from the view.
     * Validates the product and handles any entity exceptions that may occur.
     *
     * @return the modified Product object.
     */
    private Product getProduct() {
        Product product;

        while (true) {
            try {
                product = (Product) super.view.show();

                if (product.getName().equals("") && product.getDescription().equals("")
                        && product.getQuantity() == 0 && product.getUnitPrice() == 0)
                    throw new EntityException(ReadProperties.getProperty("error.entity.product-null"));
                break;

            } catch (EntityException error) {
                super.view.printException(error);
            }
        }

        return product;
    }
}
