package com.ifal.cantina.interfaces;

import com.ifal.cantina.annotations.Overload;
import com.ifal.cantina.utils.factorys.ModelFactory;
import com.ifal.cantina.utils.factorys.ViewFactory;

/**
 * Represents a controller in the application.
 * Provides a common interface and functionality for controlling the flow of data and views.
 *
 * @author Nicolas Albuquerque R.
 */
public abstract class AController {
    protected IModel model;
    protected AView view;

    /**
     * Constructs a new instance of the AController class.
     * Creates a default model and view using the ModelFactory and ViewFactory.
     */
    @Overload
    public AController() {
        this.model = ModelFactory.createModel();
        this.view = ViewFactory.createView(this);
    }

    /**
     * Constructs a new instance of the AController class.
     * Sets the specified model and view.
     *
     * @param model the model to be associated with the controller.
     * @param view  the view to be associated with the controller.
     */
    @Overload
    public AController(IModel model, AView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Runs the controller, executing the desired logic and interaction.
     */
    public abstract void run();
}
