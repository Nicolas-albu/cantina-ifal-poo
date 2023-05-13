package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.views.RegisterItemView;
import com.ifal.cantina.entities.Product;

public class RegisterItemController extends AController {
    
    public RegisterItemController() {
        super();
    }
    
    @Override
    public void run() {
        Product product = (Product) new RegisterItemView().show();
        super.model.add(product);
    }
}
