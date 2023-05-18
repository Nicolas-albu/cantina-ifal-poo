package com.ifal.cantina.views.subViews.inventoryViews;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.AView;

import java.util.ArrayList;
import java.util.List;

public class LowQuantityViewProducts extends AView {

    public LowQuantityViewProducts() {
        super();
    }

    @Override
    public Object show() throws EntityException {
        List<String> questions = new ArrayList<>() {
            {
                add("Digite o ID do produto: ");
                add("Digite a quantidade a diminuir do produto: ");
            }
        };

        System.out.println("=========================================");
        System.out.println("Baixa da Quantidade de Produto no Estoque");
        System.out.println("=========================================\n");

        int idProduct  = HandleInput.handleInteger(questions.get(0));
        int quantityProduct = HandleInput.handleInteger(questions.get(1));

        return new Product(idProduct, quantityProduct);
    }
}
