package com.ifal.cantina.entities;

import com.ifal.cantina.annotations.Field;
import com.ifal.cantina.annotations.Table;

@Table(tableName = "TBL_PRODUTO")
public class Product {
    @Field(fieldName = "cod_prod")
    private int code_product;

    @Field(fieldName = "nom_prod")
    private String name_product;

    @Field(fieldName = "val_preco_uni")
    private double price_product;

    @Field(fieldName = "qtd_prod")
    private int quantity_product;

    @Field(fieldName = "des_prod")
    private String description_product;

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
        return this.code_product;
    }

    public String getName_product() {
        return this.name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice_product() {
        return this.price_product;
    }

    public void setPrice_product(double price_product) {
        this.price_product = price_product;
    }

    public int getQuantity_product() {
        return this.quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public String getDescription_product() {
        return this.description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }
}
