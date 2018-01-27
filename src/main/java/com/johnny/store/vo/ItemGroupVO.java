package com.johnny.store.vo;

public class ItemGroupVO {
    private int itemGroupID;
    private int brandID;
    private String brandCN;
    private int categoryID;
    private String categoryCN;
    private int subCategoryID;
    private String subCategoryCN;
    private String itemGroupCN;
    private String itemGroupEN;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getItemGroupID() {
        return itemGroupID;
    }

    public void setItemGroupID(int itemGroupID) {
        this.itemGroupID = itemGroupID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getItemGroupCN() {
        return itemGroupCN;
    }

    public void setItemGroupCN(String itemGroupCN) {
        this.itemGroupCN = itemGroupCN;
    }

    public String getItemGroupEN() {
        return itemGroupEN;
    }

    public void setItemGroupEN(String itemGroupEN) {
        this.itemGroupEN = itemGroupEN;
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

    public String getBrandCN() {
        return brandCN;
    }

    public void setBrandCN(String brandCN) {
        this.brandCN = brandCN;
    }

    public String getCategoryCN() {
        return categoryCN;
    }

    public void setCategoryCN(String categoryCN) {
        this.categoryCN = categoryCN;
    }

    public String getSubCategoryCN() {
        return subCategoryCN;
    }

    public void setSubCategoryCN(String subCategoryCN) {
        this.subCategoryCN = subCategoryCN;
    }
}
