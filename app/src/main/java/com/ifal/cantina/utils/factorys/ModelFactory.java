package com.ifal.cantina.utils.factorys;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

import com.ifal.cantina.controller.RegisterItemController;
import com.ifal.cantina.model.RegisterItemModel;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.controller.Controller;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.model.Model;

public class ModelFactory {
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
