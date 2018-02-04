package com.johnny.store.dto;

public class ItemHotDTO {
    private int itemHotID;
    private int itemID;
    private String startDate;
    private String endDate;
    private String status;
    private String loginUser;

    public int getItemHotID() {
        return itemHotID;
    }

    public void setItemHotID(int itemHotID) {
        this.itemHotID = itemHotID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
