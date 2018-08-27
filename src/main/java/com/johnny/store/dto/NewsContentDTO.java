package com.johnny.store.dto;

public class NewsContentDTO {
    private int newsContentID;
    private int newsID;
    private String newsContentType;
    private String newsContent;
    private String loginUser;

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public int getNewsContentID() {
        return newsContentID;
    }

    public void setNewsContentID(int newsContentID) {
        this.newsContentID = newsContentID;
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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
