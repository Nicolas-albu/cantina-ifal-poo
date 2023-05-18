package com.ifal.cantina.interfaces;

import com.ifal.cantina.utils.factorys.ModelFactory;
import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.factorys.ViewFactory;

/**
 * <p> Represents a controller in the application.</p>
 * <p> Provides a common interface and functionality for controlling the flow of data and views.</p>
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 * @see AModel
 */
public abstract class AController {
    protected AModel model;
    protected AView view;

    /**
     * Constructs a new instance of the AController class.
     * Creates a default model and view using the ModelFactory and ViewFactory.
     */
    public AController() {
        this.model = ModelFactory.createModel(this);
        this.view = ViewFactory.createView(this);
    }

    public AController(AModel model, AView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Runs the controller, executing the desired logic and interaction.
     */
    public abstract void run();

    /**
     * Returns the obtained object by invoking the view's show() method.
     *
     * @return The object obtained from the view or null in case of an exception.
     */
    protected Object getResultShowMenu() {
        try {
            return this.view.show();
            
        } catch (EntityException error) {
            this.view.printException(error);
        }

        return null;
    }


    public void setModel(AModel model) {
        this.model = model;
    }
}
