package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class BrandHotEntity implements Serializable {
	private int brandHotID;
	private int brandID;
	private String startDate;
	private String endDate;
	private String status;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public BrandHotEntity(){
		super();
	}

	public BrandHotEntity(int brandHotID, int brandID, String startDate, String endDate, String status, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.brandHotID = brandHotID;
		this.brandID = brandID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getBrandHotID() {
		return this.brandHotID;
	}

	public void setBrandHotID(int brandHotID) {
		this.brandHotID = brandHotID;
	}

	public int getBrandID() {
		return this.brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
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