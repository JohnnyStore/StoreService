package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerEntity implements Serializable {
	private int customerID;
	private String customerName;
	private String account;
	private String password;
	private String customerSex;
	private String cellphone;
	private String email;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public CustomerEntity(){
		super();
	}

	public CustomerEntity(int customerID, String customerName, String account, String password, String customerSex, String cellphone, String email, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.account = account;
		this.password = password;
		this.customerSex = customerSex;
		this.cellphone = cellphone;
		this.email = email;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getCustomerSex() {
		return this.customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
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