package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderEntity implements Serializable {
	private int orderID;
	private int customerID;
	private Timestamp orderDate;
	private double orderAmount;
	private int countryID;
	private int shippingAddressProvinceID;
	private int shippingAddressCityID;
	private String shippingAddress;
	private String orderStatus;
	private String trackingNumber;
	private int expressCompanyID;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public OrderEntity(){
		super();
	}

	public OrderEntity(int orderID, int customerID, Timestamp orderDate, double orderAmount, int countryID, int shippingAddressProvinceID, int shippingAddressCityID, String shippingAddress, String orderStatus, String trackingNumber, int expressCompanyID, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.countryID = countryID;
		this.shippingAddressProvinceID = shippingAddressProvinceID;
		this.shippingAddressCityID = shippingAddressCityID;
		this.shippingAddress = shippingAddress;
		this.orderStatus = orderStatus;
		this.trackingNumber = trackingNumber;
		this.expressCompanyID = expressCompanyID;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
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

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public Timestamp getLastEditDate() {
		return this.lastEditDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

}