package com.ifal.cantina.controllers;

import com.ifal.cantina.utils.factorys.SummaryControllerFactory;
import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.interfaces.AController;

public class ItemSummaryController extends AController {

    public ItemSummaryController() {
        super();
    }

    @Override
    public void run() {
        int resultShowMenu = this.getResultShowMenu();
        AController summaryController;

//        while ()
        summaryController = SummaryControllerFactory.createController(resultShowMenu);
        summaryController.run();

        super.view.printResult();
        super.view.close();
    }

    private int getResultShowMenu() {
        int resultShowMenu = 0;

        try {
            resultShowMenu = (Integer) super.view.show();

        } catch (EntityException error) {
            super.view.printException(error);
        }

        return resultShowMenu;
    }
}
