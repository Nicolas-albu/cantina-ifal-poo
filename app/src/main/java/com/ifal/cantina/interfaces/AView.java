package com.ifal.cantina.interfaces;

import java.util.Scanner;

public abstract class AView {
    protected Scanner read;

    public AView() {
        this.read = new Scanner(System.in);
    }

    public abstract Object show();
}
