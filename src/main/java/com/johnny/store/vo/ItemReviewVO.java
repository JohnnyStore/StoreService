package com.johnny.store.vo;

/**
 * Created by 13425 on 2018/1/31.
 */
public class ItemReviewVO {
    private int reviewID;
    private int itemID;
    private int customerID;
    private String reviewStatus;
    private String reviewStatusText;
    private String itemCode;
    private String reviewText;  //评论内容
    private String itemShortDescriptionCN;
    private String itemShortDescriptionEN;
    private String reviewLevel;
    private String reviewLevelText;   //评论级别
    private String cellphone;
    private String customerName;
    private boolean isPending;
    private boolean isApproved;
    private boolean isReject;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;
    private String loginUser;

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewStatusText() {
        return reviewStatusText;
    }

    public void setReviewStatusText(String reviewStatusText) {
        this.reviewStatusText = reviewStatusText;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getItemShortDescriptionEN() {
        return itemShortDescriptionEN;
    }

    public void setItemShortDescriptionEN(String itemShortDescriptionEN) {
        this.itemShortDescriptionEN = itemShortDescriptionEN;
    }

    public String getReviewLevel() {
        return reviewLevel;
    }

    public void setReviewLevel(String reviewLevel) {
        this.reviewLevel = reviewLevel;
    }

    public String getReviewLevelText() {
        return reviewLevelText;
    }

    public void setReviewLevelText(String reviewLevelText) {
        this.reviewLevelText = reviewLevelText;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getItemShortDescriptionCN() {
        return itemShortDescriptionCN;
    }

    public void setItemShortDescriptionCN(String itemShortDescriptionCN) {
        this.itemShortDescriptionCN = itemShortDescriptionCN;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isReject() {
        return isReject;
    }

    public void setReject(boolean reject) {
        isReject = reject;
    }
}
