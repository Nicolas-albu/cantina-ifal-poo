package com.ifal.cantina.interfaces;

import com.ifal.cantina.utils.factorys.ModelFactory;
import com.ifal.cantina.utils.factorys.ViewFactory;

/**
 * <p> Represents a controller in the application.</p>
 * <p> Provides a common interface and functionality for controlling the flow of data and views.</p>
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 * @see IModel
 */
public abstract class AController {
    protected IModel model;
    protected AView view;

    /**
     * Constructs a new instance of the AController class.
     * Creates a default model and view using the ModelFactory and ViewFactory.
     */
    public AController() {
        this.model = ModelFactory.createModel();
        this.view = ViewFactory.createView(this);
    }

    /**
     * Runs the controller, executing the desired logic and interaction.
     */
    public abstract void run();
}
