package com.ifal.cantina.controllers;

import com.ifal.cantina.views.RegisterItemView;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.*;

public class RegisterItemController extends AController {
    
    public RegisterItemController(AModel model, AView view) {
        super(model, view);
    }
    
    @Override
    public void run() {
        Product product = (Product) new RegisterItemView().show();
        super.model.add(product);
    }
}
