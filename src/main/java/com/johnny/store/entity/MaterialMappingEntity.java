package com.johnny.store.entity;

public class MaterialMappingEntity {
	private int materialID;
	private String materialCN;
	private String materialEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

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

	public String getInDate() {
		return this.inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public String getLastEditDate() {
		return this.lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

}