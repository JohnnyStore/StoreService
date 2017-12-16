package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderTransactionEntity implements Serializable {
	private int orderTransactionID;
	private int orderID;
	private int itemID;
	private int itemCount;
	private double itemAmount;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public OrderTransactionEntity(){
		super();
	}

	public OrderTransactionEntity(int orderTransactionID, int orderID, int itemID, int itemCount, double itemAmount, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.orderTransactionID = orderTransactionID;
		this.orderID = orderID;
		this.itemID = itemID;
		this.itemCount = itemCount;
		this.itemAmount = itemAmount;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getOrderTransactionID() {
		return this.orderTransactionID;
	}

	public void setOrderTransactionID(int orderTransactionID) {
		this.orderTransactionID = orderTransactionID;
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getItemCount() {
		return this.itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public double getItemAmount() {
		return this.itemAmount;
	}

	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
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