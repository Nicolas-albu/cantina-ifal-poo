package com.ifal.cantina.views;

import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.entities.Product;

/**
 * <p> The ItemRemovalView class is a subclass of AView that represents the view for removing an
 * item from the inventory.</p>
 * <p> It interacts with the user to retrieve the necessary information and provides the result as a
 * Product object.</p>
 *
 * @author Nicolas Albuquerque R.
 * @see AView
 */
public class ItemRemovalView extends AView {

    /**
     * Constructs a new instance of the ItemRemovalView class.
     * Initializes the view using the parent class constructor.
     */
    public ItemRemovalView() {
        super();
    }

    @Override
    public Object show() {
        System.out.println("=======================");
        System.out.println("Remover item do estoque");
        System.out.println("=======================\n");

        int idProduct = HandleInput.handleInteger("Digite o ID do item: ");

        return new Product(idProduct);
    }
}
