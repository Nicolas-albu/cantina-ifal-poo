package com.ifal.cantina.controller;

import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.IController;
import com.ifal.cantina.interfaces.IModel;
import com.ifal.cantina.interfaces.IView;

public class Controller implements IController {
    private IModel model;
    private IView view;

    public Controller(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        // Show Menu
        int resultShowMenu = this.view.show();
        this.logicMenu(resultShowMenu);
    }

    private void logicMenu(int resultShow) {
        switch (resultShow) {
            case -1:
                break;
            case 1:
                Product product = this.view.showRegisterItem();
                int resultRegisterItem = this.registerItem(product);
                break;
        }
    }

    private int registerItem(Product product) {
        if (product instanceof Product) {
            System.out.println("Concluido.");
            // return this.model.registerItem(product);
        }
        return 0;
    }
}
