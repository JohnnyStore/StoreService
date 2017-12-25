package com.johnny.store.dto;

public class ItemSeriesDTO {
    private int seriesID;
    private String itemSeriesCN;
    private String itemSeriesEN;
    private String loginUser;

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public String getItemSeriesCN() {
        return itemSeriesCN;
    }

    public void setItemSeriesCN(String itemSeriesCN) {
        this.itemSeriesCN = itemSeriesCN;
    }

    public String getItemSeriesEN() {
        return itemSeriesEN;
    }

    public void setItemSeriesEN(String itemSeriesEN) {
        this.itemSeriesEN = itemSeriesEN;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
