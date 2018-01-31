package com.johnny.store.vo;

/**
 * Created by 13425 on 2018/1/29.
 */
public class ShoppingCartVO {
    private int shoppingCartID;
    private int itemID;
    private int customerID;
    private int shoppingCount;
    private double totalPrice4RMB;
    private double totalPrice4USD;
    private String status;
    private String statusText;
    private ItemVO itemVO;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public ItemVO getItemVO() {
        return itemVO;
    }

    public void setItemVO(ItemVO itemVO) {
        this.itemVO = itemVO;
    }

    public double getTotalPrice4RMB() {
        return totalPrice4RMB;
    }

    public void setTotalPrice4RMB(double totalPrice4RMB) {
        this.totalPrice4RMB = totalPrice4RMB;
    }

    public double getTotalPrice4USD() {
        return totalPrice4USD;
    }

    public void setTotalPrice4USD(double totalPrice4USD) {
        this.totalPrice4USD = totalPrice4USD;
    }
}
