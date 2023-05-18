package com.ifal.cantina.controllers;

import com.ifal.cantina.utils.factorys.ControllerFactory;
import com.ifal.cantina.interfaces.AController;

/**
 * Subclass of AController that is the main/initial Controller.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 */
public class Controller extends AController {

    /**
     * Constructs a new instance of the Controller class.
     * Initializes the model and view using the parent class constructor.
     */
    public Controller() {
        super();
    }

    @Override
    public void run() {
        int resultShowMenu = (Integer) super.getResultShowMenu();
        AController controller;

        if (resultShowMenu != 9) {
            controller = ControllerFactory.createController(resultShowMenu);
            controller.run();
        }

        super.view.printResult();
        super.view.close();
    }
}
