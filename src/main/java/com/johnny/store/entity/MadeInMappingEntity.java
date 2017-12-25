package com.johnny.store.entity;

public class MadeInMappingEntity {
	private int madeInID;
	private String madeInCN;
	private String madeInEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getMadeInID() {
		return this.madeInID;
	}

	public void setMadeInID(int madeInID) {
		this.madeInID = madeInID;
	}

	public String getMadeInCN() {
		return this.madeInCN;
	}

	public void setMadeInCN(String madeInCN) {
		this.madeInCN = madeInCN;
	}

	public String getMadeInEN() {
		return this.madeInEN;
	}

	public void setMadeInEN(String madeInEN) {
		this.madeInEN = madeInEN;
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