package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ColorEntity implements Serializable {
	private int colorID;
	private String colorCN;
	private String colorEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ColorEntity(){
		super();
	}

	public ColorEntity(int colorID, String colorCN, String colorEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.colorID = colorID;
		this.colorCN = colorCN;
		this.colorEN = colorEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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