package com.ifal.cantina.entities;

public class Product {
    int code_product;
    String name_product;
    double price_product;
    int quantity_product;
    String description_product;

    public Product ( 
        String name_product, 
        double price_product, 
        int quantity_product, 
        String description_product) {
        this.name_product = name_product;
        this.price_product = price_product;
        this.quantity_product = quantity_product;
        this.description_product = description_product;
    }

    public int getCode_product() {
        return code_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice_product() {
        return price_product;
    }

    public void setPrice_product(double price_product) {
        this.price_product = price_product;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public String getDescription_product() {
        return description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }
}
