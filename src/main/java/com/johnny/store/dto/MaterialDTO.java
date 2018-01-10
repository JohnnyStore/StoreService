package com.johnny.store.dto;

public class MaterialDTO {
    private int materialID;
    private String materialCN;
    private String materialEN;
    private String loginUser;

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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
