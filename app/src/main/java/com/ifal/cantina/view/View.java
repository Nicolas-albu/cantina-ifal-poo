package com.ifal.cantina.view;

import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.interfaces.AView;

public class View extends AView {
    
    public View() {
        super();
    }
    
    @Override
    public Object show() {
        String key_property;
        int option_choice = -1;
        int quantity_options = Integer.parseInt(
            ReadProperties.getProperty("show.menu.quantity.options"));
        

        while(option_choice == -1) {
            System.out.println("===================================================");
            System.out.println("Bem-vindo ao Controle de Estoque da Cantina do IFAL");
            System.out.println("===================================================\n");
            System.out.println("Selecione uma das seguintes opcoes:");
            
            for(int index_menu = 0; index_menu < quantity_options; index_menu++) {
                key_property = "show.menu." + (index_menu + 1);

                System.out.println((index_menu + 1) + " - " 
                        + ReadProperties.getProperty(key_property));
            }

            option_choice = Integer.parseInt(super.handleInputs
                    .handle("Digite um numero da opcao: "));
        }
    
        return option_choice;
    }
}
