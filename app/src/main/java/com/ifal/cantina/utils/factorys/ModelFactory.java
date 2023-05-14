package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.interfaces.IModel;
import com.ifal.cantina.models.Model;

/**
 * Pattern Factory to the models.
 *
 * @author Nicolas Albuquerque R.
 */
public class ModelFactory {

    /**
     * @return the instance of model.
     */
    public static IModel createModel() {
        return new Model();
    }
}
