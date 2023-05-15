package com.ifal.cantina.views;

import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.interfaces.AView;

public class ItemSummaryView extends AView {

    public ItemSummaryView() {
        super();
    }

    @Override
    public Object show() {
        String key_property;
        int quantity_options = Integer.parseInt(
                ReadProperties.getProperty("show.summary.quantity.options"));

        System.out.println("===========================");
        System.out.println("Resumo dos Itens do Estoque");
        System.out.println("===========================\n");
        System.out.println("Selecione uma das seguintes opcoes: ");

        for (int index_menu = 0; index_menu < quantity_options; index_menu++) {
            key_property = "show.summary." + (index_menu + 1);

            System.out.printf("[%s] - %s%n",
                    (index_menu + 1), ReadProperties.getProperty(key_property));
        }

        return HandleInput.handleInteger("Digite um numero da opcao: ", quantity_options);
    }
}
