package com.ifal.cantina.controller;

import com.ifal.cantina.view.RegisterItemView;
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
