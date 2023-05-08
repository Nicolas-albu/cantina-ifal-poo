package com.ifal.cantina.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import com.ifal.cantina.entities.Product;
import com.ifal.cantina.interfaces.IView;

public class View implements IView {
    Scanner read = null;

    public View() {
        this.read = new Scanner(System.in);
    }

    public int show() {
        int option_choice = -1;
        Map<Integer, String> options = new HashMap<>() 
        {
            {
                put(1, "Cadastrar item no estoque");
                put(2, "Alterar item no estoque");
                put(3, "Excluir item no estoque");
                put(4, "Dar baixa nos itens vendidos do estoque");
                put(5, "Resumo dos itens");
                put(6, "Resumo dos lucros");
                put(7, "Adicionar funcionario");
                put(8, "Remover funcionario");
                put(9, "Sair");
            }
        };
    
        while(true) {
            try {
                System.out.println("===================================================");
                System.out.println("Bem-vindo ao Controle de Estoque da Cantina do IFAL");
                System.out.println("===================================================");
                System.out.println("Selecione uma das seguintes opcoes:");
                for(int index_options = 0; index_options < options.size(); index_options++) {
                    System.out.println((index_options + 1) + " - " + options.get(index_options + 1));
                }
                System.out.println("Digite um numero da opcao: ");
                option_choice = read.nextInt();
                break;
            } catch (InputMismatchException error) {
                System.err.println("insira apenas numeros inteiros.\n");
                read.nextLine();
                continue;
            }
        }
    
        return option_choice;
    }

    public Product showRegisterItem() {
        String name_product = null;
        int quantity_product = 0;
        double price_product = 0.0;
        String description_product = null;
        System.out.println("=========================");
        System.out.println("Cadastrar item no estoque");
        System.out.println("=========================");
        
        try {
            System.out.println("Digite o nome do item: ");
            name_product = read.nextLine();

        } catch (NoSuchElementException error) {
            System.err.println("insira apenas letras.\n");
            read.nextLine();
        }

        try {
            System.out.println("Digite a descricao do item: ");
            description_product = read.nextLine();

        } catch (NoSuchElementException error) {
            System.err.println("insira apenas letras.\n");
            read.nextLine();
        }
    
        try {
            System.out.println("Digite a quantidade do item: ");
            quantity_product = read.nextInt();

        } catch (InputMismatchException error) {
            System.err.println("insira apenas numeros inteiros.\n");
            read.nextLine();
        }
        
        try {
            System.out.println("Digite o preco do item: ");
            price_product = read.nextDouble();

        } catch (InputMismatchException error) {
            System.err.println("insira apenas numeros inteiros ou decimais.\n");
            read.nextLine();
        }        

        return new Product(name_product, price_product, quantity_product, description_product);
    }
}
