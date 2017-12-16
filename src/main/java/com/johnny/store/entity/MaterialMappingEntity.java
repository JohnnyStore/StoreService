package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class MaterialMappingEntity implements Serializable {
	private int materialID;
	private String materialCN;
	private String materialEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public MaterialMappingEntity(){
		super();
	}

	public MaterialMappingEntity(int materialID, String materialCN, String materialEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.materialID = materialID;
		this.materialCN = materialCN;
		this.materialEN = materialEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getMaterialID() {
		return this.materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}

	public String getMaterialCN() {
		return this.materialCN;
	}

	public void setMaterialCN(String materialCN) {
		this.materialCN = materialCN;
	}

	public String getMaterialEN() {
		return this.materialEN;
	}

	public void setMaterialEN(String materialEN) {
		this.materialEN = materialEN;
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