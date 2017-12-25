package com.johnny.store.vo;

import java.sql.Timestamp;

public class ProvinceVO {
    private int provinceID;
    private int countryID;
    private String provinceNameCN;
    private String provinceNameEN;
    private String inUser;
    private Timestamp inDate;
    private String lastEditUser;
    private Timestamp lastEditDate;

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
    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }


}
