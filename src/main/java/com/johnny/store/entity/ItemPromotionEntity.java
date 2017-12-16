package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ItemPromotionEntity implements Serializable {
	private int itemPromotionID;
	private int itemID;
	private String startDate;
	private String endDate;
	private String status;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ItemPromotionEntity(){
		super();
	}

	public ItemPromotionEntity(int itemPromotionID, int itemID, String startDate, String endDate, String status, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.itemPromotionID = itemPromotionID;
		this.itemID = itemID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getItemPromotionID() {
		return this.itemPromotionID;
	}

	public void setItemPromotionID(int itemPromotionID) {
		this.itemPromotionID = itemPromotionID;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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