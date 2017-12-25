package com.johnny.store.entity;

public class CountryEntity {
	private int countryID;
	private String countryNameCN;
	private String countryNameEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getCountryID() {
		return this.countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public String getCountryNameCN() {
		return this.countryNameCN;
	}

	public void setCountryNameCN(String countryNameCN) {
		this.countryNameCN = countryNameCN;
	}

	public String getCountryNameEN() {
		return this.countryNameEN;
	}

	public void setCountryNameEN(String countryNameEN) {
		this.countryNameEN = countryNameEN;
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