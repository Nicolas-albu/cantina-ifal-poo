package com.ifal.cantina.views;

import java.util.ArrayList;
import java.util.List;

import com.ifal.cantina.entities.Product;
import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.utils.HandleInput;

/**
 * Subclass of AView for create new object Product.
 *
 * @author Nicolas Albuquerque R.
 */
public class RegisterItemView extends AView {

    /**
     * Create the new instance of RegisterItemView.
     */
    public RegisterItemView() {
        super();
    }

    @Override
    public Object show() throws EntityException {
        System.out.println("=========================");
        System.out.println("Cadastrar item no estoque");
        System.out.println("=========================\n");

        List<String> questions = new ArrayList<>()
        {
            {
                add("Digite o nome do item: ");
                add("Digite a descricao do item: ");
                add("Digite a quantidade do item: ");
                add("Digite o preco do item: ");
            }
        };

        String name_product = HandleInput.handleString(questions.get(0));
        String description_product = HandleInput.handleString(questions.get(1));

        int quantity_product = HandleInput.handleInteger(questions.get(2));
        double price_product = HandleInput.handleDouble(questions.get(3));

        return new Product(name_product, price_product, quantity_product, description_product);
    }
}
