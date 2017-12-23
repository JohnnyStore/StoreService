package com.johnny.store.vo;

import java.sql.Timestamp;

/**
 * 商品二级分类 VO
 * @Author liqian
 */
public class SubCategoryVO {
    private int subCategoryID;
    private String subCategoryCN;
    private String subCategoryEN;
    private String inUser;
    private Timestamp inDate;
    private String lastEditUser;
    private Timestamp lastEditDate;

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

    public Timestamp getInDate() {
        return inDate;
    }

    public void setInDate(Timestamp inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
