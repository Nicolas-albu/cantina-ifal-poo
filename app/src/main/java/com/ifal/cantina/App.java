/*
 * This Java source file contains the class that initializes the application.
 */
package com.ifal.cantina;

import com.ifal.cantina.controllers.Controller;
import com.ifal.cantina.interfaces.AController;

/**
 * Application initializer class.
 *
 * @author Nicolas Albuquerque R.
 */
public class App {

    /**
     * Application initializer method.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        AController controller = new Controller();
        controller.run();
    }
}
