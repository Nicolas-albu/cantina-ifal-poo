package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;

public class Controller extends AController {

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
//            case 2:

        }
    }
}
