package com.johnny.store.vo;

public class MaterialVO {
    private int materialID;
    private String materialCN;
    private String materialEN;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getMaterialCN() {
        return materialCN;
    }

    public void setMaterialCN(String materialCN) {
        this.materialCN = materialCN;
    }

    public String getMaterialEN() {
        return materialEN;
    }

    public void setMaterialEN(String materialEN) {
        this.materialEN = materialEN;
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
