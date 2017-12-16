package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class MadeInMappingEntity implements Serializable {
	private int madeInID;
	private String madeInCN;
	private String madeInEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public MadeInMappingEntity(){
		super();
	}

	public MadeInMappingEntity(int madeInID, String madeInCN, String madeInEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.madeInID = madeInID;
		this.madeInCN = madeInCN;
		this.madeInEN = madeInEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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