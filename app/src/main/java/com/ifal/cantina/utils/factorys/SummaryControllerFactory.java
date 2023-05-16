package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.controllers.subControllers.summaryControllers.*;
import com.ifal.cantina.interfaces.AController;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

public class SummaryControllerFactory {
    public static AController createController(int choice) {
        Map<Integer, Supplier<AController>> typeControllers = new HashMap<>() {
            {
                put(1, ItemSummaryControllerSortedByDescription::new);
                put(2, ItemSummaryControllerSortedByQuantity::new);
                put(3, ItemSummaryControllerWithLowQuantity::new);
            }
        };

        return typeControllers.getOrDefault(choice, () -> null).get();
    }
}
