package com.ifal.cantina.controllers;

import com.ifal.cantina.utils.factorys.ControllerFactory;
import com.ifal.cantina.exceptions.EntityException;
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
        int resultShowMenu = this.getResultShowMenu();
        AController controller;

//        while (resultShowMenu != 9) {
//            resultShowMenu = this.getResultShowMenu();
            controller = ControllerFactory.createController(resultShowMenu);
            controller.run();
//        }

        super.view.printResult();
        super.view.close();
    }

    /**
     * Retrieves the user's choice from the View component.
     *
     * @return The user's choice as an integer.
     */
    private int getResultShowMenu() {
        int resultShowMenu = 9;

        try {
            resultShowMenu = (Integer) super.view.show();

        } catch (EntityException error) {
            super.view.printException(error);
        }

        return resultShowMenu;
    }
}
