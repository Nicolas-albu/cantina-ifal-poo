package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.interfaces.AView;

public class Controller extends AController {

    public Controller(AModel model, AView view) {
        super(model, view);
    }

    @Override
    public void run() {
        int resultShowMenu = (Integer) super.view.show();
        
        switch (resultShowMenu) {
            case 9:
                break;
            case 1:
                new RegisterItemController(super.model, super.view).run();
                break;
        }
    }
}
