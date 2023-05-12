package com.ifal.cantina.utils.factorys;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

import com.ifal.cantina.controllers.RegisterItemController;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.controllers.Controller;

import com.ifal.cantina.views.RegisterItemView;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.views.View;


public class ViewFactory {
    public static AView createView(AController controller) {
        Map<Class<? extends AController>, Supplier<AView>> typeControllers = new HashMap<>() {
            {
                put(Controller.class, View::new);
                put(RegisterItemController.class, RegisterItemView::new);
            }
        };

        return typeControllers.getOrDefault(controller.getClass(), () -> null).get();
    }
}
