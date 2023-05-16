package com.ifal.cantina.entities;

import com.ifal.cantina.annotations.*;

@DBTable(tableName = "TBL_ITENS")
public class Item {
    @Id
    @DBField(fieldName = "cod_prod")
    private int idProduct;

    @Id
    @DBField(fieldName = "cod_venda")
    private int idSale;

    @DBField(fieldName = "prc_desconto")
    private double discountPercentage;

    @DBField(fieldName = "qtd_itens")
    private int quantityOfItens;

    @DBField(fieldName = "val_preco_compra")
    private double purchasePrice;

    public Item(int idProduct, int idSale, double discountPercentage, int quantityOfItens, double purchasePrice) {
        this.idProduct = idProduct;
        this.idSale = idSale;
        this.discountPercentage = discountPercentage;
        this.quantityOfItens = quantityOfItens;
        this.purchasePrice = purchasePrice;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getQuantityOfItens() {
        return quantityOfItens;
    }

    public void setQuantityOfItens(int quantityOfItens) {
        this.quantityOfItens = quantityOfItens;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
