package com.johnny.store.dto;

import java.util.List;

public class OrderDTO {
    private int orderID;
    private int customerID;
    private String orderDate;
    private String orderAmount;
    private int shippingAddressID;
    private String orderStatus;
    private int expressCompanyID;
    private List<OrderTransactionDTO> orderTransactionDTOList;
    private String trackingNumber;
    private String refundReason;
    private String memo;
    private String loginUser;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getShippingAddressID() {
        return shippingAddressID;
    }

    public void setShippingAddressID(int shippingAddressID) {
        this.shippingAddressID = shippingAddressID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getExpressCompanyID() {
        return expressCompanyID;
    }

    public void setExpressCompanyID(int expressCompanyID) {
        this.expressCompanyID = expressCompanyID;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public List<OrderTransactionDTO> getOrderTransactionDTOList() {
        return orderTransactionDTOList;
    }

    public void setOrderTransactionDTOList(List<OrderTransactionDTO> orderTransactionDTOList) {
        this.orderTransactionDTOList = orderTransactionDTOList;
    }
}
