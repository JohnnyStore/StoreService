package com.johnny.store.dto;

public class ColorDTO {
    private int colorID;
    private String colorCN;
    private String colorEN;
    private String loginUser;

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColorCN() {
        return colorCN;
    }

    public void setColorCN(String colorCN) {
        this.colorCN = colorCN;
    }

    public String getColorEN() {
        return colorEN;
    }

    public void setColorEN(String colorEN) {
        this.colorEN = colorEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
