package com.ifal.cantina.entities;

import com.ifal.cantina.annotations.DBTable;

import java.sql.Date;

enum PAYMENT {
    DEBIT, CREDIT, CASH;
}

@DBTable(tableName = "TBL_VENDA")
public class Sale {
    private int idSale;
    private Date saleDate;
    private double totalPrice;
    private PAYMENT formOfPayment;

    public Sale(Date saleDate, double totalPrice, PAYMENT formOfPayment) {
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;
        this.formOfPayment = formOfPayment;
    }

    public int getIdSale() {
        return idSale;
    }

//    public void setIdSale(int idSale) {
//        this.idSale = idSale;
//    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PAYMENT getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(PAYMENT formOfPayment) {
        this.formOfPayment = formOfPayment;
    }
}
