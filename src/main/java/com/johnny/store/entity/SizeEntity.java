package com.johnny.store.entity;

public class SizeEntity {
	private int sizeID;
	private String sizeCN;
	private String sizeEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getSizeID() {
		return this.sizeID;
	}

	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}

	public String getSizeCN() {
		return this.sizeCN;
	}

	public void setSizeCN(String sizeCN) {
		this.sizeCN = sizeCN;
	}

	public String getSizeEN() {
		return this.sizeEN;
	}

	public void setSizeEN(String sizeEN) {
		this.sizeEN = sizeEN;
	}

	public String getInUser() {
		return this.inUser;
	}

	public void setInUser(String inUser) {
		this.inUser = inUser;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
}