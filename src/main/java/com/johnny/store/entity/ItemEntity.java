package com.johnny.store.entity;
import java.io.Serializable;
import java.sql.Timestamp;

public class ItemEntity implements Serializable {
	private int itemID;
	private int brandID;
	private int categoryID;
	private int subCategoryID;
	private int seriesID;
	private String itemNameCN;
	private String itemNameEN;
	private double untiPrice;
	private double promotionPrice;
	private float rate;
	private int colorID;
	private int sizeID;
	private int materialID;
	private String adjustLengthCN;
	private String adjustLengthEN;
	private String suitablePetCN;
	private String suitablePetEN;
	private String itemShortDescriptionCN;
	private String itemShortDescriptionEN;
	private String itemDescriptionCN;
	private String itemDescriptionEN;
	private String itemStatus;
	private String inUser;
	private Timestamp inDate;
	private String lastEditUser;
	private Timestamp lastEditDate;

	public ItemEntity(){
		super();
	}

	public ItemEntity(int itemID, int brandID, int categoryID, int subCategoryID, int seriesID, String itemNameCN, String itemNameEN, double untiPrice, double promotionPrice, float rate, int colorID, int sizeID, int materialID, String adjustLengthCN, String adjustLengthEN, String suitablePetCN, String suitablePetEN, String itemShortDescriptionCN, String itemShortDescriptionEN, String itemDescriptionCN, String itemDescriptionEN, String itemStatus, String inUser, Timestamp inDate, String lastEditUser, Timestamp lastEditDate){
		super();
		this.itemID = itemID;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.subCategoryID = subCategoryID;
		this.seriesID = seriesID;
		this.itemNameCN = itemNameCN;
		this.itemNameEN = itemNameEN;
		this.untiPrice = untiPrice;
		this.promotionPrice = promotionPrice;
		this.rate = rate;
		this.colorID = colorID;
		this.sizeID = sizeID;
		this.materialID = materialID;
		this.adjustLengthCN = adjustLengthCN;
		this.adjustLengthEN = adjustLengthEN;
		this.suitablePetCN = suitablePetCN;
		this.suitablePetEN = suitablePetEN;
		this.itemShortDescriptionCN = itemShortDescriptionCN;
		this.itemShortDescriptionEN = itemShortDescriptionEN;
		this.itemDescriptionCN = itemDescriptionCN;
		this.itemDescriptionEN = itemDescriptionEN;
		this.itemStatus = itemStatus;
		this.inUser = inUser;
		this.inDate = inDate;
		this.lastEditUser = lastEditUser;
		this.lastEditDate = lastEditDate;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getBrandID() {
		return this.brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getSubCategoryID() {
		return this.subCategoryID;
	}

	public void setSubCategoryID(int subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public int getSeriesID() {
		return this.seriesID;
	}

	public void setSeriesID(int seriesID) {
		this.seriesID = seriesID;
	}

	public String getItemNameCN() {
		return this.itemNameCN;
	}

	public void setItemNameCN(String itemNameCN) {
		this.itemNameCN = itemNameCN;
	}

	public String getItemNameEN() {
		return this.itemNameEN;
	}

	public void setItemNameEN(String itemNameEN) {
		this.itemNameEN = itemNameEN;
	}

	public double getUntiPrice() {
		return this.untiPrice;
	}

	public void setUntiPrice(double untiPrice) {
		this.untiPrice = untiPrice;
	}

	public double getPromotionPrice() {
		return this.promotionPrice;
	}

	public void setPromotionPrice(double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public float getRate() {
		return this.rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getColorID() {
		return this.colorID;
	}

	public void setColorID(int colorID) {
		this.colorID = colorID;
	}

	public int getSizeID() {
		return this.sizeID;
	}

	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}

	public int getMaterialID() {
		return this.materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}

	public String getAdjustLengthCN() {
		return this.adjustLengthCN;
	}

	public void setAdjustLengthCN(String adjustLengthCN) {
		this.adjustLengthCN = adjustLengthCN;
	}

	public String getAdjustLengthEN() {
		return this.adjustLengthEN;
	}

	public void setAdjustLengthEN(String adjustLengthEN) {
		this.adjustLengthEN = adjustLengthEN;
	}

	public String getSuitablePetCN() {
		return this.suitablePetCN;
	}

	public void setSuitablePetCN(String suitablePetCN) {
		this.suitablePetCN = suitablePetCN;
	}

	public String getSuitablePetEN() {
		return this.suitablePetEN;
	}

	public void setSuitablePetEN(String suitablePetEN) {
		this.suitablePetEN = suitablePetEN;
	}

	public String getItemShortDescriptionCN() {
		return this.itemShortDescriptionCN;
	}

	public void setItemShortDescriptionCN(String itemShortDescriptionCN) {
		this.itemShortDescriptionCN = itemShortDescriptionCN;
	}

	public String getItemShortDescriptionEN() {
		return this.itemShortDescriptionEN;
	}

	public void setItemShortDescriptionEN(String itemShortDescriptionEN) {
		this.itemShortDescriptionEN = itemShortDescriptionEN;
	}

	public String getItemDescriptionCN() {
		return this.itemDescriptionCN;
	}

	public void setItemDescriptionCN(String itemDescriptionCN) {
		this.itemDescriptionCN = itemDescriptionCN;
	}

	public String getItemDescriptionEN() {
		return this.itemDescriptionEN;
	}

	public void setItemDescriptionEN(String itemDescriptionEN) {
		this.itemDescriptionEN = itemDescriptionEN;
	}

	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
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