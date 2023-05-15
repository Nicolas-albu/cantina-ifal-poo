package com.ifal.cantina.views;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.AView;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclass of AView for create new object Product.
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 */
public class ItemRegisterView extends AView {

    /**
     * Create the new instance of ItemRegisterView.
     */
    public ItemRegisterView() {
        super();
    }

    @Override
    public Object show() throws EntityException {
        System.out.println("=========================");
        System.out.println("Cadastrar item no estoque");
        System.out.println("=========================\n");

        List<String> questions = new ArrayList<>() {
            {
                add("Digite o nome do produto: ");
                add("Digite a descricao do produto: ");
                add("Digite a quantidade do produto: ");
                add("Digite o preco unitario do produto: ");
            }
        };

        String nameProduct = HandleInput.handleString(questions.get(0));
        String descriptionProduct = HandleInput.handleNonEmptyString(questions.get(1));

        int quantityProduct = HandleInput.handleInteger(questions.get(2));
        double priceProduct = HandleInput.handleDouble(questions.get(3));

        return new Product(nameProduct, priceProduct, quantityProduct, descriptionProduct);
    }
}
