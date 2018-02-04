package com.johnny.store.dto;

public class ItemPromotionDTO {
    private int itemPromotionID;
    private int itemID;
    private String startDate;
    private String endDate;
    private String status;
    private String loginUser;

    public int getItemPromotionID() {
        return itemPromotionID;
    }

    public void setItemPromotionID(int itemPromotionID) {
        this.itemPromotionID = itemPromotionID;
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
