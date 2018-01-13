package com.johnny.store.dto;

public class ExpressCompanyDTO {
    private int companyID;
    private String companyCN;
    private String companyEN;
    private String loginUser;

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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
