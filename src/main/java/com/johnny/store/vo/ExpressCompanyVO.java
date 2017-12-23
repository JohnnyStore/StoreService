package com.johnny.store.vo;

import java.sql.Timestamp;

public class ExpressCompanyVO {
    private int companyID;
    private String companyCN;
    private String companyEN;
    private String inUser;
    private Timestamp inDate;
    private String lastEditUser;
    private Timestamp lastEditDate;

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyCN() {
        return companyCN;
    }

    public void setCompanyCN(String companyCN) {
        this.companyCN = companyCN;
    }

    public String getCompanyEN() {
        return companyEN;
    }

    public void setCompanyEN(String companyEN) {
        this.companyEN = companyEN;
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
