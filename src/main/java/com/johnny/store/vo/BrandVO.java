package com.johnny.store.vo;

public class BrandVO {
    private int brandID;
    private String brandCN;
    private String brandEN;
    private String imageSrc;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
