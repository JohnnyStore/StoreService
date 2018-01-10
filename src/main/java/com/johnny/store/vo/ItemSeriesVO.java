package com.johnny.store.vo;

public class ItemSeriesVO {
    private int seriesID;
    private String itemSeriesCN;
    private String itemSeriesEN;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
