package com.ifal.cantina.utils.factorys;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

import com.ifal.cantina.controllers.summaryControllers.*;
import com.ifal.cantina.views.summariesViews.*;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.controllers.*;
import com.ifal.cantina.views.*;

/**
 * Pattern Factory to the views corresponding to your controllers.
 *
 * @author Nicolas Albuquerque R.
 * @see AController
 * @see AView
 */
public class ViewFactory {

    /**
     * @return the instance of view.
     */
    public static AView createView(AController controller) {
        Map<Class<? extends AController>, Supplier<AView>> typeControllers = new HashMap<>() {
            {
                put(Controller.class, View::new);
                put(ItemRegisterController.class, ItemRegisterView::new);
                put(ItemChangeController.class, ItemChangeView::new);
                put(ItemRemovalController.class, ItemRemovalView::new);
                put(ItemSummaryController.class, ItemSummaryView::new);
                put(ItemSummaryControllerSortedByDescription.class, ItemSummaryViewSortedByDescription::new);
                put(ItemSummaryControllerSortedByQuantity.class,
                        ItemSummaryViewSortedByQuantity::new);
            }
        };

        return typeControllers.getOrDefault(controller.getClass(), () -> null).get();
    }
}
