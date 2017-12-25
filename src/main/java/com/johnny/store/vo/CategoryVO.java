package com.johnny.store.vo;

import java.sql.Timestamp;

/**
 * 商品一级分类 VO
 * @Author liqian
 */
public class CategoryVO {
    private int categoryID;
    private String categoryCN;
    private String categoryEN;
    private String inUser;
    private Timestamp inDate;
    private String lastEditUser;
    private Timestamp lastEditDate;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryCN() {
        return categoryCN;
    }

    public void setCategoryCN(String categoryCN) {
        this.categoryCN = categoryCN;
    }

    public String getCategoryEN() {
        return categoryEN;
    }

    public void setCategoryEN(String categoryEN) {
        this.categoryEN = categoryEN;
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
