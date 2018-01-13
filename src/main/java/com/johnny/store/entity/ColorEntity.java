package com.johnny.store.entity;

public class ColorEntity{
	private int colorID;
	private String colorCN;
	private String colorEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getColorID() {
		return this.colorID;
	}

	public void setColorID(int colorID) {
		this.colorID = colorID;
	}

	public String getColorCN() {
		return this.colorCN;
	}

	public void setColorCN(String colorCN) {
		this.colorCN = colorCN;
	}

	public String getColorEN() {
		return this.colorEN;
	}

	public void setColorEN(String colorEN) {
		this.colorEN = colorEN;
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