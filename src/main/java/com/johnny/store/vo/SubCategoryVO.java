package com.johnny.store.vo;

public class SubCategoryVO {
    private int subCategoryID;
    private String subCategoryCN;
    private String subCategoryEN;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryCN() {
        return subCategoryCN;
    }

    public void setSubCategoryCN(String subCategoryCN) {
        this.subCategoryCN = subCategoryCN;
    }

    public String getSubCategoryEN() {
        return subCategoryEN;
    }

    public void setSubCategoryEN(String subCategoryEN) {
        this.subCategoryEN = subCategoryEN;
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
