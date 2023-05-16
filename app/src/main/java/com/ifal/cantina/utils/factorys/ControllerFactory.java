package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.controllers.*;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    public static AController createController(int optionMenu) {
        Map<Integer, Supplier<AController>> options = new HashMap<>() {
            {
                put(1, ItemRegisterController::new);
                put(2, ItemChangeController::new);
                put(3, ItemRemovalController::new);
                put(4, InventoryProductQuantityController::new);
                put(5, ItemSummaryController::new);
            }
        };

        return options.getOrDefault(optionMenu, () -> null).get();
    }
}
