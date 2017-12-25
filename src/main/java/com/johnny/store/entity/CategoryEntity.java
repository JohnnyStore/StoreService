package com.johnny.store.entity;

public class CategoryEntity {
	private int categoryID;
	private String categoryCN;
	private String categoryEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryCN() {
		return this.categoryCN;
	}

	public void setCategoryCN(String categoryCN) {
		this.categoryCN = categoryCN;
	}

	public String getCategoryEN() {
		return this.categoryEN;
	}

	public void setCategoryEN(String categoryEN) {
		this.categoryEN = categoryEN;
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