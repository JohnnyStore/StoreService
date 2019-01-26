package com.johnny.store.vo;

public class OrderTransactionVO {
    private int orderTransactionID;
    private int orderID;
    private int itemID;
    private ItemVO itemVO;
    private int itemCount;
    private double itemAmount;
    private String currencyType;
    private Boolean customerReviewed;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public ItemVO getItemVO() {
        return itemVO;
    }

    public void setItemVO(ItemVO itemVO) {
        this.itemVO = itemVO;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Boolean getCustomerReviewed() {
        return customerReviewed;
    }

    public void setCustomerReviewed(Boolean customerReviewed) {
        this.customerReviewed = customerReviewed;
    }
}
