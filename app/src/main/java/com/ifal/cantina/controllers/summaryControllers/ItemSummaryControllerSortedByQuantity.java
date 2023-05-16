package com.ifal.cantina.controllers.summaryControllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

public class ItemSummaryControllerSortedByQuantity extends AController {

    public ItemSummaryControllerSortedByQuantity() {
        super();
    }

    @Override
    public void run() {
        try {
            super.model.query(Product.class, "qtd_prod").commit(super.view);

        } catch (SQLException error) {
            super.view.printException(error);
        }

        super.view.close();
    }
}
