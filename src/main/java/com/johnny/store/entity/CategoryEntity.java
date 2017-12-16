package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class CategoryEntity implements Serializable {
	private int categoryID;
	private String categoryCN;
	private String categoryEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public CategoryEntity(){
		super();
	}

	public CategoryEntity(int categoryID, String categoryCN, String categoryEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.categoryID = categoryID;
		this.categoryCN = categoryCN;
		this.categoryEN = categoryEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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