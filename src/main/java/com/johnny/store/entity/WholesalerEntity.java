package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class WholesalerEntity implements Serializable {
	private int wholesalerID;
	private String password;
	private String cellphone;
	private String email;
	private String status;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public WholesalerEntity(){
		super();
	}

	public WholesalerEntity(int wholesalerID, String password, String cellphone, String email, String status, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.wholesalerID = wholesalerID;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.status = status;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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