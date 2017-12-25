package com.johnny.store.entity;

public class WholesalerEntity {
	private int wholesalerID;
	private String password;
	private String cellphone;
	private String email;
	private String status;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getWholesalerID() {
		return this.wholesalerID;
	}

	public void setWholesalerID(int wholesalerID) {
		this.wholesalerID = wholesalerID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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