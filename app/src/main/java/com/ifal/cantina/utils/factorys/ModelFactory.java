package com.ifal.cantina.utils.factorys;

import com.ifal.cantina.controllers.subControllers.inventoryControllers.HighQuantityControllerProducts;
import com.ifal.cantina.controllers.subControllers.inventoryControllers.LowQuantityControllerProducts;
import com.ifal.cantina.interfaces.AController;
import com.ifal.cantina.interfaces.AModel;
import com.ifal.cantina.models.ItemModel;
import com.ifal.cantina.models.ProductModel;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Pattern Factory to the models.
 *
 * @author Nicolas Albuquerque R.
 */
public class ModelFactory {

    /**
     * @return the instance of model.
     */
    public static AModel createModel(AController controller) {
        var models = new HashMap<Class<? extends AController>, Supplier<AModel>>() {
            {
                put(LowQuantityControllerProducts.class, ItemModel::new);
                put(HighQuantityControllerProducts.class, ItemModel::new);
            }
        };

        return models.getOrDefault(controller.getClass(), ProductModel::new).get();
    }
}
