package com.ifal.cantina.interfaces;

import java.util.Scanner;

import com.ifal.cantina.utils.HandleInput;

public abstract class AView {
    protected HandleInput handleInputs;
    protected Scanner read;

    public AView() {
        this.read = new Scanner(System.in);
        this.handleInputs = new HandleInput(this.read);
    }

    public abstract Object show();
}
