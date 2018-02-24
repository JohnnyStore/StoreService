package com.johnny.store.dto;

public class OrderTransactionDTO {
    private int orderTransactionID;
    private int orderID;
    private int itemID;
    private int itemCount;
    private double itemAmount;
    private String loginUser;

    public int getOrderTransactionID() {
        return orderTransactionID;
    }

    public void setOrderTransactionID(int orderTransactionID) {
        this.orderTransactionID = orderTransactionID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
