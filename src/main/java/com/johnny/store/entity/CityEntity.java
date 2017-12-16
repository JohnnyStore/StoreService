package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class CityEntity implements Serializable {
	private int cityID;
	private int countryID;
	private int provinceID;
	private String cityNameCN;
	private String cityNameEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public CityEntity(){
		super();
	}

	public CityEntity(int cityID, int countryID, int provinceID, String cityNameCN, String cityNameEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.cityID = cityID;
		this.countryID = countryID;
		this.provinceID = provinceID;
		this.cityNameCN = cityNameCN;
		this.cityNameEN = cityNameEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getCityID() {
		return this.cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public int getCountryID() {
		return this.countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public int getProvinceID() {
		return this.provinceID;
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public String getCityNameCN() {
		return this.cityNameCN;
	}

	public void setCityNameCN(String cityNameCN) {
		this.cityNameCN = cityNameCN;
	}

	public String getCityNameEN() {
		return this.cityNameEN;
	}

	public void setCityNameEN(String cityNameEN) {
		this.cityNameEN = cityNameEN;
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