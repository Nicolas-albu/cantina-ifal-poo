package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.controllers.subControllers.inventoryControllers.*;
import com.ifal.cantina.interfaces.*;

import java.util.function.BiFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InventoryControllerFactory {
    public static AController createInventoryController(int choice, AModel model, AView view) {
        Map<Integer, Supplier<AController>> options = new HashMap<>() {
            {
                put(1, LowQuantityControllerProducts::new);
                put(2, HighQuantityControllerProducts::new);
            }
        };

        return options.getOrDefault(choice, () -> null).get();
    }
}
