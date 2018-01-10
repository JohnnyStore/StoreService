package com.johnny.store.dto;

public class ProvinceDTO {
    private int provinceID;
    private int countryID;
    private String provinceNameCN;
    private String provinceNameEN;
    private String loginUser;


    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getProvinceNameCN() {
        return provinceNameCN;
    }

    public void setProvinceNameCN(String provinceNameCN) {
        this.provinceNameCN = provinceNameCN;
    }

    public String getProvinceNameEN() {
        return provinceNameEN;
    }

    public void setProvinceNameEN(String provinceNameEN) {
        this.provinceNameEN = provinceNameEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }


}
