package com.johnny.store.dto;

public class DailySnapUpDTO {
    private int snapUpID;
    private int itemID;
    private String snapUpDate;
    private double snapUpPrice4RMB;
    private double snapUpPrice4USD;
    private String status;
    private String loginUser;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSnapUpID() {
        return snapUpID;
    }

    public void setSnapUpID(int snapUpID) {
        this.snapUpID = snapUpID;
    }

    public String getSnapUpDate() {
        return snapUpDate;
    }

    public void setSnapUpDate(String snapUpDate) {
        this.snapUpDate = snapUpDate;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public double getSnapUpPrice4RMB() {
        return snapUpPrice4RMB;
    }

    public void setSnapUpPrice4RMB(double snapUpPrice4RMB) {
        this.snapUpPrice4RMB = snapUpPrice4RMB;
    }

    public double getSnapUpPrice4USD() {
        return snapUpPrice4USD;
    }

    public void setSnapUpPrice4USD(double snapUpPrice4USD) {
        this.snapUpPrice4USD = snapUpPrice4USD;
    }
}
