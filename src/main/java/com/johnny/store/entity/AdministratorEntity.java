package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class AdministratorEntity implements Serializable {
	private int administratorID;
	private String administratorName;
	private String account;
	private String password;
	private String cellphone;
	private String email;
	private String customerRole;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public AdministratorEntity(){
		super();
	}

	public AdministratorEntity(int administratorID, String administratorName, String account, String password, String cellphone, String email, String customerRole, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.administratorID = administratorID;
		this.administratorName = administratorName;
		this.account = account;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.customerRole = customerRole;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getAdministratorID() {
		return this.administratorID;
	}

	public void setAdministratorID(int administratorID) {
		this.administratorID = administratorID;
	}

	public String getAdministratorName() {
		return this.administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getCustomerRole() {
		return this.customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
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