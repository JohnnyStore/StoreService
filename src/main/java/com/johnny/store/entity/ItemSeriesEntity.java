package com.johnny.store.entity;

public class ItemSeriesEntity {
	private int seriesID;
	private String itemSeriesCN;
	private String itemSeriesEN;
	private String inUser;
	private String inDate;
	private String lastEditUser;
	private String lastEditDate;

	public int getSeriesID() {
		return this.seriesID;
	}

	public void setSeriesID(int seriesID) {
		this.seriesID = seriesID;
	}

	public String getItemSeriesCN() {
		return this.itemSeriesCN;
	}

	public void setItemSeriesCN(String itemSeriesCN) {
		this.itemSeriesCN = itemSeriesCN;
	}

	public String getItemSeriesEN() {
		return this.itemSeriesEN;
	}

	public void setItemSeriesEN(String itemSeriesEN) {
		this.itemSeriesEN = itemSeriesEN;
	}

	public String getInUser() {
		return this.inUser;
	}

	public void setInUser(String inUser) {
		this.inUser = inUser;
	}

	public String getLastEditUser() {
		return this.lastEditUser;
	}

	public void setLastEditUser(String lastEditUser) {
		this.lastEditUser = lastEditUser;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
}