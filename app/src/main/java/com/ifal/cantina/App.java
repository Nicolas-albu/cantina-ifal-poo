/*
 * This Java source file contains the class that initializes the application.
 */
package com.ifal.cantina;

import com.ifal.cantina.controller.Controller;
import com.ifal.cantina.model.Model;
import com.ifal.cantina.view.View;
import com.ifal.cantina.interfaces.*;

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
        AModel model = new Model();
        AView view = new View();
        AController controller = new Controller(model, view);
        
        controller.run();
    }
}
