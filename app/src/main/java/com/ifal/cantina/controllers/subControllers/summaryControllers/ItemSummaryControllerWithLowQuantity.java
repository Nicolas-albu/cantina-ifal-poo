package com.ifal.cantina.controllers.subControllers.summaryControllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

public class ItemSummaryControllerWithLowQuantity extends AController {

    public ItemSummaryControllerWithLowQuantity() {
        super();
    }

    @Override
    public void run() {
        try {
            super.model.query(Product.class, "qtd_prod", 50).commit(super.view);

        } catch (SQLException error) {
            super.view.printException(error);
        }

        super.view.close();
    }
}
