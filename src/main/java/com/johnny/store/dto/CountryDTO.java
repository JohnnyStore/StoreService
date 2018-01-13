package com.johnny.store.dto;

public class CountryDTO {
    private int countryID;
    private String countryNameCN;
    private String countryNameEN;
    private String loginUser;


    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryNameCN() {
        return countryNameCN;
    }

    public void setCountryNameCN(String countryNameCN) {
        this.countryNameCN = countryNameCN;
    }

    public String getCountryNameEN() {
        return countryNameEN;
    }

    public void setCountryNameEN(String countryNameEN) {
        this.countryNameEN = countryNameEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
