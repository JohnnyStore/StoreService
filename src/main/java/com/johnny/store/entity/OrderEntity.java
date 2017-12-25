package com.johnny.store.entity;

public class OrderEntity {
	private int orderID;
	private int customerID;
	private String orderDate;
	private double orderAmount;
	private int countryID;
	private int shippingAddressProvinceID;
	private int shippingAddressCityID;
	private String shippingAddress;
	private String orderStatus;
	private String trackingNumber;
	private int expressCompanyID;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getCountryID() {
		return this.countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public int getShippingAddressProvinceID() {
		return this.shippingAddressProvinceID;
	}

	public void setShippingAddressProvinceID(int shippingAddressProvinceID) {
		this.shippingAddressProvinceID = shippingAddressProvinceID;
	}

	public int getShippingAddressCityID() {
		return this.shippingAddressCityID;
	}

	public void setShippingAddressCityID(int shippingAddressCityID) {
		this.shippingAddressCityID = shippingAddressCityID;
	}

	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getTrackingNumber() {
		return this.trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public int getExpressCompanyID() {
		return this.expressCompanyID;
	}

	public void setExpressCompanyID(int expressCompanyID) {
		this.expressCompanyID = expressCompanyID;
	}

	public String getInUser() {
		return this.inUser;
	}

	public void setInUser(String inUser) {
		this.inUser = inUser;
	}

	public String getInDate() {
		return this.inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public String getLastEditDate() {
		return this.lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

}