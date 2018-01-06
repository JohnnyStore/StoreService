package com.johnny.store.dto;

public class BrandDTO {
    private int brandID;
    private String brandCN;
    private String brandEN;
    private String brandImageUrl;
    private String loginUser;

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandCN() {
        return brandCN;
    }

    public void setBrandCN(String brandCN) {
        this.brandCN = brandCN;
    }

    public String getBrandEN() {
        return brandEN;
    }

    public void setBrandEN(String brandEN) {
        this.brandEN = brandEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getBrandImageUrl() {
        return brandImageUrl;
    }

    public void setBrandImageUrl(String brandImageUrl) {
        this.brandImageUrl = brandImageUrl;
    }
}
