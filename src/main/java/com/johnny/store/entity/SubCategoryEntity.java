package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class SubCategoryEntity implements Serializable {
	private int subCategoryID;
	private String subCategoryCN;
	private String subCategoryEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public SubCategoryEntity(){
		super();
	}

	public SubCategoryEntity(int subCategoryID, String subCategoryCN, String subCategoryEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.subCategoryID = subCategoryID;
		this.subCategoryCN = subCategoryCN;
		this.subCategoryEN = subCategoryEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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