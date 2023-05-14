package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;

/**
 * Subclass of AController that is the main/initial Controller.
 *
 * @author Nicolas Albuquerque R.
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
        int resultShowMenu = (Integer) super.view.show();

        switch (resultShowMenu) {
            case 9:
                break;
            case 1:
                new RegisterItemController().run();
                break;
        }
    }
}
