package com.ifal.cantina.views;

import com.ifal.cantina.interfaces.AView;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.utils.ReadProperties;

/**
 * Subclass of AView which is the main/initial View, for selecting menu options.
 *
 * @author Nicolas Albuquerque R.
 */
public class View extends AView {

    /**
     * Create the new instance of View.
     */
    public View() {
        super();
    }

    @Override
    public Object show() {
        String key_property;
        int quantity_options = Integer.parseInt(
                ReadProperties.getProperty("show.menu.quantity.options"));

        System.out.println("===================================================");
        System.out.println("Bem-vindo ao Controle de Estoque da Cantina do IFAL");
        System.out.println("===================================================\n");
        System.out.println("Selecione uma das seguintes opcoes: ");

        for (int index_menu = 0; index_menu < quantity_options; index_menu++) {
            key_property = "show.menu." + (index_menu + 1);

            System.out.printf("[%s] - %s%n",
                    (index_menu + 1), ReadProperties.getProperty(key_property));
        }

        return HandleInput.handleInteger("Digite um numero da opcao: ", quantity_options);
    }
}
