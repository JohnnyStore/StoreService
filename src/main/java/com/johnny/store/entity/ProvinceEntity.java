package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ProvinceEntity implements Serializable {
	private int provinceID;
	private int countryID;
	private String provinceNameCN;
	private String provinceNameEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ProvinceEntity(){
		super();
	}

	public ProvinceEntity(int provinceID, int countryID, String provinceNameCN, String provinceNameEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.provinceID = provinceID;
		this.countryID = countryID;
		this.provinceNameCN = provinceNameCN;
		this.provinceNameEN = provinceNameEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getProvinceID() {
		return this.provinceID;
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public int getCountryID() {
		return this.countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	public String getProvinceNameCN() {
		return this.provinceNameCN;
	}

	public void setProvinceNameCN(String provinceNameCN) {
		this.provinceNameCN = provinceNameCN;
	}

	public String getProvinceNameEN() {
		return this.provinceNameEN;
	}

	public void setProvinceNameEN(String provinceNameEN) {
		this.provinceNameEN = provinceNameEN;
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