package com.johnny.store.dto;

public class ItemPromotionDTO {
    private int itemPromotionID;
    private int itemID;
    private String startDate;
    private String endDate;
    private String promotionPrice4RMB;
    private String promotionPrice4USD;
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

    public String getPromotionPrice4RMB() {
        return promotionPrice4RMB;
    }

    public void setPromotionPrice4RMB(String promotionPrice4RMB) {
        this.promotionPrice4RMB = promotionPrice4RMB;
    }

    public String getPromotionPrice4USD() {
        return promotionPrice4USD;
    }

    public void setPromotionPrice4USD(String promotionPrice4USD) {
        this.promotionPrice4USD = promotionPrice4USD;
    }
}
