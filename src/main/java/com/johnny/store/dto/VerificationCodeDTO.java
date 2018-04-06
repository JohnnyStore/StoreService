package com.johnny.store.dto;

public class VerificationCodeDTO {
    private int verificationCodeID;
    private String cellphone;
    private String email;
    private String verificationCode;
    private String loginUser;

    public int getVerificationCodeID() {
        return verificationCodeID;
    }

    public void setVerificationCodeID(int verificationCodeID) {
        this.verificationCodeID = verificationCodeID;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
