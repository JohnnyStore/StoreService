package com.johnny.store.vo;

import java.util.List;

public class OrderVO {
    private int orderID;
    private int customerID;
    private CustomerVO customerVO;
    private String orderDate;
    private String orderAmount;
    private int shippingAddressID;
    private ShippingAddressVO shippingAddressVO;
    private String orderStatus;
    private String orderStatusText;
    private int expressCompanyID;
    private ExpressCompanyVO expressCompanyVO;
    private List<OrderTransactionVO> orderTransactionList;
    private String trackingNumber;
    private String refundReason;
    private String memo;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
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

    public CustomerVO getCustomerVO() {
        return customerVO;
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO = customerVO;
    }

    public ShippingAddressVO getShippingAddressVO() {
        return shippingAddressVO;
    }

    public void setShippingAddressVO(ShippingAddressVO shippingAddressVO) {
        this.shippingAddressVO = shippingAddressVO;
    }

    public ExpressCompanyVO getExpressCompanyVO() {
        return expressCompanyVO;
    }

    public void setExpressCompanyVO(ExpressCompanyVO expressCompanyVO) {
        this.expressCompanyVO = expressCompanyVO;
    }

    public List<OrderTransactionVO> getOrderTransactionList() {
        return orderTransactionList;
    }

    public void setOrderTransactionList(List<OrderTransactionVO> orderTransactionList) {
        this.orderTransactionList = orderTransactionList;
    }
}
