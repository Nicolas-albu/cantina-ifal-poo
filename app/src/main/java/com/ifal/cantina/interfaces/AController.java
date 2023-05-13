package com.ifal.cantina.interfaces;

import com.ifal.cantina.annotations.Overload;
import com.ifal.cantina.utils.factorys.ModelFactory;
import com.ifal.cantina.utils.factorys.ViewFactory;

public abstract class AController {
    protected AModel model;
    protected AView view;

    @Overload
    public AController(){
        this.model = ModelFactory.createModel(this);
        this.view = ViewFactory.createView(this);
    }

    @Overload
    public AController(AModel model, AView view) {
        this.model = model;
        this.view = view;
    }

    public abstract void run();
}
