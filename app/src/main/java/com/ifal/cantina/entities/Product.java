package com.ifal.cantina.entities;

import com.ifal.cantina.annotations.DBField;
import com.ifal.cantina.annotations.DBTable;

/**
 * Represents a Product entity in the application.
 * Annotated with the table name and fields for database mapping.
 *
 * @author Nicolas Albuquerque R.
 */
@DBTable(tableName = "TBL_PRODUTO")
public class Product {
    @DBField(fieldName = "cod_prod")
    private int code_product;

    @DBField(fieldName = "nom_prod")
    private String name_product;

    @DBField(fieldName = "val_preco_uni")
    private double price_product;

    @DBField(fieldName = "qtd_prod")
    private int quantity_product;

    @DBField(fieldName = "des_prod")
    private String description_product;

    /**
     * Constructs a new instance of the Product class.
     *
     * @param name_product the name of the product.
     * @param price_product the price of the product.
     * @param quantity_product the quantity of the product.
     * @param description_product the description of the product.
     */
    public Product(
            String name_product,
            double price_product,
            int quantity_product,
            String description_product) {
        this.name_product = name_product;
        this.price_product = price_product;
        this.quantity_product = quantity_product;
        this.description_product = description_product;
    }

    /**
     * Gets the code of the product.
     *
     * @return the code of the product.
     */
    public int getCode_product() {
        return this.code_product;
    }

    /**
     * Sets the code of the product.
     *
     * @param code_product the code of the product.
     */
    public void setCode_product(int code_product) {
        this.code_product = code_product;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product.
     */
    public String getName_product() {
        return this.name_product;
    }

    /**
     * Sets the name of the product.
     *
     * @param name_product the name of the product.
     */
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product.
     */
    public double getPrice_product() {
        return this.price_product;
    }

    /**
     * Sets the price of the product.
     *
     * @param price_product the price of the product.
     */
    public void setPrice_product(double price_product) {
        this.price_product = price_product;
    }

    /**
     * Gets the quantity of the product.
     *
     * @return the quantity of the product.
     */
    public int getQuantity_product() {
        return this.quantity_product;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity_product the quantity of the product.
     */
    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    /**
     * Gets the description of the product.
     *
     * @return the description of the product.
     */
    public String getDescription_product() {
        return this.description_product;
    }

    /**
     * Sets the description of the product.
     *
     * @param description_product the description of the product.
     */
    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }
}
