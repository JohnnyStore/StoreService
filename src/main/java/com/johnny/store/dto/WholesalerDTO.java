package com.johnny.store.dto;

public class WholesalerDTO {
    private int wholesalerID;
    private String password;
    private String cellphone;
    private String email;
    private String status;
    private String loginUser;

    public int getWholesalerID() {
        return wholesalerID;
    }

    public void setWholesalerID(int wholesalerID) {
        this.wholesalerID = wholesalerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
