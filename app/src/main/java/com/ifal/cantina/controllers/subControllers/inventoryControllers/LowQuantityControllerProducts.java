package com.ifal.cantina.controllers.subControllers.inventoryControllers;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.*;
import com.ifal.cantina.utils.factorys.ModelFactory;

import java.sql.SQLException;

public class LowQuantityControllerProducts extends AController {

    private final AModel itemModel;
    private final AModel saleModel;

    public LowQuantityControllerProducts() {
        super();
        this.itemModel = ModelFactory.createModel(this);
        this.saleModel = ModelFactory.createModel(this);
    }

    @Override
    public void run() {
        Product productWithLowQuantity;
        int newQuantity;

        while (true) {
            productWithLowQuantity = (Product) super.getResultShowMenu();

            try {
                int actualQuantity = (Integer) super.model.query(productWithLowQuantity
                        .getIdentifier(), productWithLowQuantity.getClass(), "qtd_prod")
                        .commitWithReturn("qtd_prod");

                newQuantity = actualQuantity - productWithLowQuantity.getQuantity();
                if (newQuantity < 0)
                    throw new EntityException(ReadProperties
                            .getProperty("error.entity.cannot-quantity-less-current-quantity"));

                int quantityOnTableItem = productWithLowQuantity.getQuantity();

                productWithLowQuantity.setQuantity(newQuantity);

                super.model.update(productWithLowQuantity, "qtd_prod").commit();

//                this.saleModel.insert()

//                this.itemModel.update()
                break;

            } catch (IllegalAccessException | SQLException | EntityException error) {
                super.view.printException(error);
            }
        }

        super.view.close();
    }
}
