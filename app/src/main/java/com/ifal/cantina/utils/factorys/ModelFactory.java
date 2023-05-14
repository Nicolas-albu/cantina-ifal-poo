package com.ifal.cantina.utils.factorys;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.controllers.*;
import com.ifal.cantina.models.*;

/**
 * Pattern Factory to the models corresponding to your controllers.
 *
 * @author Nicolas Albuquerque R.
 */
public class ModelFactory {

    /**
     * @return the instance of model.
     */
    public static AModel createModel(AController controller) {
        Map<Class<? extends AController>, Supplier<AModel>> typeControllers = new HashMap<>() {
            {
                put(Controller.class, Model::new);
                put(RegisterItemController.class, RegisterItemModel::new);
            }
        };

        return typeControllers.getOrDefault(controller.getClass(), () -> null).get();
    }
}
