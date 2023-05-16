package com.ifal.cantina.controllers.summaryControllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.entities.Product;

import java.sql.SQLException;

public class ItemSummaryControllerSortedByDescription extends AController {

    public ItemSummaryControllerSortedByDescription() {
        super();
    }

    @Override
    public void run() {
        try {
            super.model.query(Product.class, "des_prod").commit(super.view);

        } catch (SQLException error) {
            super.view.printException(error);
        }

        super.view.close();
    }
}
