package com.johnny.store.dto;

public class ShoppingCartDTO {
    private int shoppingCartID;
    private int itemID;
    private int customerID;
    private int shoppingCount;
    private String status;
    private String loginUser;

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShoppingCount() {
        return shoppingCount;
    }

    public void setShoppingCount(int shoppingCount) {
        this.shoppingCount = shoppingCount;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
