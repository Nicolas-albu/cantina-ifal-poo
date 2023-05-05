package com.ifal.cantina.controller;

import com.ifal.cantina.model.Model;
import com.ifal.cantina.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {

    }
}
