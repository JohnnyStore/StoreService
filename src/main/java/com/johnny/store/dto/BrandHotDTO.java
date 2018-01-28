package com.johnny.store.dto;

public class BrandHotDTO {
    private int brandHotID;
    private int brandID;
    private String startDate;
    private String endDate;
    private String status;
    private String loginUser;

    public int getBrandHotID() {
        return this.brandHotID;
    }

    public void setBrandHotID(int brandHotID) {
        this.brandHotID = brandHotID;
    }

    public int getBrandID() {
        return this.brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return this.status;
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
