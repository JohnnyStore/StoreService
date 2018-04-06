package com.johnny.store.vo;

public class VerificationCodeVO {
    private int verificationCodeID;
    private String cellphone;
    private String email;
    private String verificationCode;
    private String sendTime;
    private boolean expired;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getInUser() {
        return this.inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getLastEditUser() {
        return this.lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
