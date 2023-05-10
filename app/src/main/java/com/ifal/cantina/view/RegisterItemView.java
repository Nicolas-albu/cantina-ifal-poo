package com.ifal.cantina.view;

import java.util.ArrayList;
import java.util.List;

import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.AView;

public class RegisterItemView extends AView {
    
    public RegisterItemView() {
        super();
    }

    public Object show() {
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

        String name_product = super.handleInputs.handle(questions.get(0));
        String description_product = super.handleInputs.handle(questions.get(1));

        int quantity_product = Integer.parseInt(
            super.handleInputs.handle(questions.get(2)));

        double price_product = Double.parseDouble(
             super.handleInputs.handle(questions.get(3)));

        return new Product(name_product, price_product, quantity_product, description_product);
    }
}
