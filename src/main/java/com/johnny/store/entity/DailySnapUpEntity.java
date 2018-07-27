package com.johnny.store.entity;

public class DailySnapUpEntity {
    private int snapUpID;
    private int itemID;
    private String itemCode;
    private String itemImageUrl;
    private String itemShortDescriptionCN;
    private String itemShortDescriptionEN;
    private double unitPrice4RMB;
    private double unitPrice4USD;
    private String brandCN;
    private String brandEN;
    private String snapUpDate;
    private double snapUpPrice4RMB;
    private double snapUpPrice4USD;
    private String status;
    private String statusText;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemShortDescriptionCN() {
        return itemShortDescriptionCN;
    }

    public void setItemShortDescriptionCN(String itemShortDescriptionCN) {
        this.itemShortDescriptionCN = itemShortDescriptionCN;
    }

    public String getItemShortDescriptionEN() {
        return itemShortDescriptionEN;
    }

    public void setItemShortDescriptionEN(String itemShortDescriptionEN) {
        this.itemShortDescriptionEN = itemShortDescriptionEN;
    }

    public String getBrandCN() {
        return brandCN;
    }

    public void setBrandCN(String brandCN) {
        this.brandCN = brandCN;
    }

    public String getBrandEN() {
        return brandEN;
    }

    public void setBrandEN(String brandEN) {
        this.brandEN = brandEN;
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

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public double getUnitPrice4RMB() {
        return unitPrice4RMB;
    }

    public void setUnitPrice4RMB(double unitPrice4RMB) {
        this.unitPrice4RMB = unitPrice4RMB;
    }

    public double getUnitPrice4USD() {
        return unitPrice4USD;
    }

    public void setUnitPrice4USD(double unitPrice4USD) {
        this.unitPrice4USD = unitPrice4USD;
    }
}
