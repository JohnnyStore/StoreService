package com.johnny.store.entity;

public class ProvinceEntity {
	private int provinceID;
	private int countryID;
	private String countryNameCN;
	private String countryNameEN;
	private String provinceNameCN;
	private String provinceNameEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	/**
	 *
	 * @return
	 */
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

	public String getCountryNameCN() {
		return countryNameCN;
	}

	public void setCountryNameCN(String countryNameCN) {
		this.countryNameCN = countryNameCN;
	}

	public String getCountryNameEN() {
		return countryNameEN;
	}

	public void setCountryNameEN(String countryNameEN) {
		this.countryNameEN = countryNameEN;
	}
}