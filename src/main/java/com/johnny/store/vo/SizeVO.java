package com.johnny.store.vo;

public class SizeVO {
    private int sizeID;
    private String sizeCN;
    private String sizeEN;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
