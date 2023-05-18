package com.ifal.cantina.controllers.subControllers.inventoryControllers;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.*;

import java.sql.SQLException;

public class HighQuantityControllerProducts extends AController {

    public HighQuantityControllerProducts() {
        super();
    }

    @Override
    public void run() {
        Product productWithLowQuantity;
        int newQuantity;

        while (true) {
            productWithLowQuantity = (Product) super.getResultShowMenu();

            try {
                int actualQuantity = (Integer) super.model.query(productWithLowQuantity
                                .getIdentifier(), productWithLowQuantity.getClass(), "qtd_prod")
                        .commitWithReturn("qtd_prod");

                newQuantity = actualQuantity + productWithLowQuantity.getQuantity();
                productWithLowQuantity.setQuantity(newQuantity);

                super.model.update(productWithLowQuantity, "qtd_prod").commit();
                break;

            } catch (IllegalAccessException | SQLException | EntityException error) {
                super.view.printException(error);
            }
        }

        super.view.close();
    }
}
