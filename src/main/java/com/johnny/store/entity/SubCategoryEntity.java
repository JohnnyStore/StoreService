package com.johnny.store.entity;

public class SubCategoryEntity {
	private int subCategoryID;
	private String subCategoryCN;
	private String subCategoryEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getSubCategoryID() {
		return this.subCategoryID;
	}

	public void setSubCategoryID(int subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public String getSubCategoryCN() {
		return this.subCategoryCN;
	}

	public void setSubCategoryCN(String subCategoryCN) {
		this.subCategoryCN = subCategoryCN;
	}

	public String getSubCategoryEN() {
		return this.subCategoryEN;
	}

	public void setSubCategoryEN(String subCategoryEN) {
		this.subCategoryEN = subCategoryEN;
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