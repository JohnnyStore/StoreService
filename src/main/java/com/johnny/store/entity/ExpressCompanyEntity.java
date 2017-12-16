package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ExpressCompanyEntity implements Serializable {
	private int companyID;
	private String companyCN;
	private String companyEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ExpressCompanyEntity(){
		super();
	}

	public ExpressCompanyEntity(int companyID, String companyCN, String companyEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.companyID = companyID;
		this.companyCN = companyCN;
		this.companyEN = companyEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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