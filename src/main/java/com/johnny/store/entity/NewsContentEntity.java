package com.johnny.store.entity;

public class NewsContentEntity {
    private int newsContentID;
    private int newsID;
    private String newsContentType;
    private String newsContent;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getNewsContentID() {
        return newsContentID;
    }

    public void setNewsContentID(int newsContentID) {
        this.newsContentID = newsContentID;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getNewsContentType() {
        return newsContentType;
    }

    public void setNewsContentType(String newsContentType) {
        this.newsContentType = newsContentType;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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
