package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class SizeMappingEntity implements Serializable {
	private int sizeID;
	private String sizeCN;
	private String sizeEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public SizeMappingEntity(){
		super();
	}

	public SizeMappingEntity(int sizeID, String sizeCN, String sizeEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.sizeID = sizeID;
		this.sizeCN = sizeCN;
		this.sizeEN = sizeEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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