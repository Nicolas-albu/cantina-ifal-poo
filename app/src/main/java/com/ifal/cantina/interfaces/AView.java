package com.ifal.cantina.interfaces;

import java.util.Scanner;

/**
 * Represents a view in the application.
 * Provides a common interface for displaying information and interacting with the user.
 *
 * @author Nicolas Albuquerque R.
 */
public abstract class AView {
    protected Scanner read;

    /**
     * Constructs a new instance of the AView class.
     * Initializes the Scanner for user input.
     */
    public AView() {
        this.read = new Scanner(System.in);
    }

    /**
     * Displays the view and handles user interaction.
     *
     * @return an object representing the result of the user interaction
     */
    public abstract Object show();
}
