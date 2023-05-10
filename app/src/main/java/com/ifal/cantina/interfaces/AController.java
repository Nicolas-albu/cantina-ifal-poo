package com.ifal.cantina.interfaces;

import com.ifal.cantina.utils.factorys.ModelFactory;
import com.ifal.cantina.utils.factorys.ViewFactory;

public abstract class AController {
    protected AModel model;
    protected AView view;

    public AController(AModel model, AView view) {
        this.model = ModelFactory.createModel(this);
        this.view = ViewFactory.createView(this);
    }

    public abstract void run();
}
