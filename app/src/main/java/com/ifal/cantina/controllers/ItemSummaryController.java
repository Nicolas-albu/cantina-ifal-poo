package com.ifal.cantina.controllers;

import com.ifal.cantina.utils.factorys.SummaryControllerFactory;
import com.ifal.cantina.interfaces.AController;

public class ItemSummaryController extends AController {

    public ItemSummaryController() {
        super();
    }

    @Override
    public void run() {
        int resultShowMenu = (Integer) super.getResultShowMenu();
        AController summaryController;

        summaryController = SummaryControllerFactory.createController(resultShowMenu);
        summaryController.run();

        super.view.printResult();
        super.view.close();
    }
}
