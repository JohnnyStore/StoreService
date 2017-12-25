package com.johnny.store.entity;


public class ExpressCompanyEntity {
	private int companyID;
	private String companyCN;
	private String companyEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getCompanyID() {
		return this.companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanyCN() {
		return this.companyCN;
	}

	public void setCompanyCN(String companyCN) {
		this.companyCN = companyCN;
	}

	public String getCompanyEN() {
		return this.companyEN;
	}

	public void setCompanyEN(String companyEN) {
		this.companyEN = companyEN;
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