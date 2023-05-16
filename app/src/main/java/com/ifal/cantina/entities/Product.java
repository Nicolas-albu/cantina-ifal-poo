package com.ifal.cantina.entities;

import com.ifal.cantina.exceptions.EntityException;
import com.ifal.cantina.utils.ReadProperties;
import com.ifal.cantina.annotations.*;
import com.ifal.cantina.utils.Utils;

/**
 * Represents a Product entity in the application.
 * Annotated with the table name and fields for database mapping.
 *
 * @author Nicolas Albuquerque R.
 * @see DBTable
 * @see DBField
 * @see Id
 */
@DBTable(tableName = "TBL_PRODUTO")
public class Product {
    @Id
    @DBField(fieldName = "cod_prod")
    private int identifier;

    @DBField(fieldName = "qtd_prod")
    private int quantity;

    @DBField(fieldName = "nom_prod")
    private String name;

    @DBField(fieldName = "des_prod")
    private String description;

    @DBField(fieldName = "val_preco_uni")
    private double unitPrice;

    /**
     * Constructs a new instance of the Product class with the specified identifier.
     *
     * @param id the identifier of the product.
     */
    @Overload
    public Product(int id) {
        this.identifier = id;
    }

    @Overload
    public Product(int id, int quantity) throws EntityException {
        this.identifier = id;
        this.setQuantity(quantity);
    }

    /**
     * Constructs a new instance of the Product class.
     *
     * @param name        the name of the product.
     * @param unitPrice   the unitPrice of the product.
     * @param quantity    the quantity of the product.
     * @param description the description of the product.
     */
    @Overload
    public Product(String name, double unitPrice, int quantity,
                   String description) throws EntityException {
        this.setName(name);
        this.setUnitPrice(unitPrice);
        this.setQuantity(quantity);
        this.setDescription(description);
    }

    @Overload
    public Product(int id, String name, double unitPrice, int quantity, String description) {
        this.setIdentifier(id);
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.description = description;
    }

    /**
     * Gets the identifier of the product.
     *
     * @return the identifier of the product.
     */
    public int getIdentifier() {
        return this.identifier;
    }

    private void setIdentifier(int id) {
        if (id > 0)
            this.identifier = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name of the product.
     */
    public void setName(String name) throws EntityException {
        if (name.isBlank() || name.isEmpty() || Utils.containsOnlyInteger(name))
            throw new EntityException(ReadProperties.getProperty("error.entity.name"));

        this.name = name;
    }

    /**
     * Gets the unitPrice of the product.
     *
     * @return the unitPrice of the product.
     */
    public double getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets the unitPrice of the product.
     *
     * @param unitPrice the unitPrice of the product.
     */
    public void setUnitPrice(double unitPrice) throws EntityException {
        if (unitPrice < 0)
            throw new EntityException(ReadProperties
                    .getProperty("error.entity.expect-unitPrice-greater-than-zero"));

        this.unitPrice = unitPrice;
    }

    /**
     * Gets the quantity of the product.
     *
     * @return the quantity of the product.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity the quantity of the product.
     */
    public void setQuantity(int quantity) throws EntityException {
        if (quantity < 0)
            throw new EntityException(ReadProperties
                    .getProperty("error.entity.expect-quantity-greater-than-zero"));

        this.quantity = quantity;
    }

    /**
     * Gets the description of the product.
     *
     * @return the description of the product.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
