package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class CountryEntity implements Serializable {
	private int countryID;
	private String countryNameCN;
	private String countryNameEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public CountryEntity(){
		super();
	}

	public CountryEntity(int countryID, String countryNameCN, String countryNameEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.countryID = countryID;
		this.countryNameCN = countryNameCN;
		this.countryNameEN = countryNameEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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