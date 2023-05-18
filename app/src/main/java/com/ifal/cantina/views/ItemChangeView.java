package com.ifal.cantina.views;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.AView;

import java.util.ArrayList;
import java.util.List;

/**
 * A view class for changing an item in the inventory.
 * This class extends the abstract class AView.
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 */
public class ItemChangeView extends AView {

    /**
     * Constructs an instance of ItemChangeView.
     * Calls the superclass constructor.
     */
    public ItemChangeView() {
        super();
    }

    @Override
    public Object show() throws EntityException {
        List<String> questions = new ArrayList<>() {
            {
                add("Digite o ID do produto que deseja alterar: ");
                add("Digite o nome do produto: ");
                add("Digite a descricao do produto: ");
                add("Digite a quantidade do produto: ");
                add("Digite o preco unitario do produto: ");
            }
        };

        System.out.println("=========================");
        System.out.println("Alteracao item no estoque");
        System.out.println("=========================\n");

        int idProduct  = HandleInput.handleInteger(questions.get(0));

        String nameProduct = HandleInput.handleNonEmptyString(questions.get(1));
        String descriptionProduct = HandleInput.handleNonEmptyString(questions.get(2));

        int quantityProduct = HandleInput.handleNonEmptyInteger(questions.get(3));
        double priceProduct = HandleInput.handleNonEmptyDouble(questions.get(4));

        return new Product(idProduct, nameProduct, priceProduct, quantityProduct,
                descriptionProduct);
    }
}
