package com.ifal.cantina.controllers;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.views.RegisterItemView;
import com.ifal.cantina.entities.Product;

/**
 * Subclass of AController to control item registration.
 *
 * @author Nicolas Albuquerque R.
 */
public class RegisterItemController extends AController {

    /**
     * Constructs a new instance of the RegisterItemController class.
     * Initializes the model and view using the parent class constructor.
     */
    public RegisterItemController() {
        super();
    }
    
    @Override
    public void run() {
        Product product = (Product) new RegisterItemView().show();
        super.model.insert(product);
    }
}
