package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ItemSeriesEntity implements Serializable {
	private int seriesID;
	private String itemSeriesCN;
	private String itemSeriesEN;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ItemSeriesEntity(){
		super();
	}

	public ItemSeriesEntity(int seriesID, String itemSeriesCN, String itemSeriesEN, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.seriesID = seriesID;
		this.itemSeriesCN = itemSeriesCN;
		this.itemSeriesEN = itemSeriesEN;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

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