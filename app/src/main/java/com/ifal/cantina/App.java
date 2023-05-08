/*
 * This Java source file contains the class that initializes the application.
 */
package com.ifal.cantina;

import com.ifal.cantina.utils.ConnectionFactory;
import com.ifal.cantina.controller.Controller;
import com.ifal.cantina.interfaces.IModel;
import com.ifal.cantina.interfaces.IView;
import com.ifal.cantina.model.Model;
import com.ifal.cantina.view.View;

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
        IModel model = new Model(ConnectionFactory.createConnection());
        IView view = new View();
        Controller controller = new Controller(model, view);
        
        controller.run();
    }
}
