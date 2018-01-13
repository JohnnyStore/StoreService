package com.johnny.store.dto;

public class SizeDTO {
    private int sizeID;
    private String sizeCN;
    private String sizeEN;
    private String loginUser;

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeCN() {
        return sizeCN;
    }

    public void setSizeCN(String sizeCN) {
        this.sizeCN = sizeCN;
    }

    public String getSizeEN() {
        return sizeEN;
    }

    public void setSizeEN(String sizeEN) {
        this.sizeEN = sizeEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
