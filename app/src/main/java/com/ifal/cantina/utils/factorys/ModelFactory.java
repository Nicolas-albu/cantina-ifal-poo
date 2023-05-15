package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.interfaces.AModel;
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
    public static AModel createModel() {
        return new Model();
    }
}
