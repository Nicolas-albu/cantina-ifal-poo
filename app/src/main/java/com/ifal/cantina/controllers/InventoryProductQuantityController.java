package com.ifal.cantina.controllers;

import com.ifal.cantina.utils.factorys.InventoryControllerFactory;
import com.ifal.cantina.interfaces.AController;

public class InventoryProductQuantityController extends AController {

    public InventoryProductQuantityController() {
        super();
    }

    @Override
    public void run() {
        int resultShowMenu = (Integer) super.getResultShowMenu();
        AController inventoryController;

        inventoryController = InventoryControllerFactory.createInventoryController(resultShowMenu,
                super.model, super.view);
        inventoryController.run();

        super.view.printResult();
        super.view.close();
    }
}
