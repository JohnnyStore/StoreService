package com.johnny.store.dto;

public class ItemGroupDTO {
    private int itemGroupID;
    private int brandID;
    private int categoryID;
    private int subCategoryID;
    private String itemGroupCN;
    private String itemGroupEN;
    private String loginUser;

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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
