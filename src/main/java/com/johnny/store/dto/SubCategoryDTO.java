package com.johnny.store.dto;

/**
 * 商品二级分类 DTO
 * @Author liqian
 */
public class SubCategoryDTO {
    private int subCategoryID;
    private String subCategoryCN;
    private String subCategoryEN;
    private String loginUser;

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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
