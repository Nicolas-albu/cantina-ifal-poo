package com.ifal.cantina.views;

import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.utils.HandleInput;
import com.ifal.cantina.interfaces.AView;

public class InventoryProductQuantityView extends AView {

    public InventoryProductQuantityView() {
        super();
    }

    @Override
    public Object show() {
        String keyProperty;
        int quantityOptions = Integer.parseInt(
                ReadProperties.getProperty("show.summary.quantity.options"));

        System.out.println("====================================");
        System.out.println("Atualizacao de Quantidade no Estoque");
        System.out.println("====================================\n");
        System.out.println("Selecione uma das seguintes opcoes: ");

        for (int indexMenu = 0; indexMenu < quantityOptions; indexMenu++) {
            keyProperty = "show.inventory." + (indexMenu + 1);

            System.out.printf("[%s] - %s%n",
                    (indexMenu + 1), ReadProperties.getProperty(keyProperty));
        }

        return HandleInput.handleInteger("Digite um numero da opcao: ", quantityOptions);
    }
}
