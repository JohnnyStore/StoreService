package com.johnny.store.dto;

import java.util.List;
import java.util.Map;

public class ItemDTO {
    private int itemID;
    private int brandID;
    private int categoryID;
    private int subCategoryID;
    private int seriesID;
    private String itemNameCN;
    private String itemNameEN;
    private double unitPrice;
    private double promotionPrice;
    private float rate;
    private int colorID;
    private int sizeID;
    private int materialID;
    private String materialCN;
    private String materialEN;
    private int madeInID;
    private String adjustLengthCN;
    private String adjustLengthEN;
    private String suitablePetCN;
    private String suitablePetEN;
    private String itemShortDescriptionCN;
    private String itemShortDescriptionEN;
    private String itemDescriptionCN;
    private String itemDescriptionEN;
    private String itemStatus;
    private List<String> itemOriginalImageList;
    private List<String> itemNormalImageList;
    private List<String> itemThumbnailImageList;
    private Map<Integer, String> itemDetailImageMap;
    private String loginUser;

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

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(double untiPrice) {
        this.unitPrice = untiPrice;
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

    public String getMaterialCN() {
        return materialCN;
    }

    public void setMaterialCN(String materialCN) {
        this.materialCN = materialCN;
    }

    public String getMaterialEN() {
        return materialEN;
    }

    public void setMaterialEN(String materialEN) {
        this.materialEN = materialEN;
    }

    public int getMadeInID() {
        return madeInID;
    }

    public void setMadeInID(int madeInID) {
        this.madeInID = madeInID;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public List<String> getItemOriginalImageList() {
        return itemOriginalImageList;
    }

    public void setItemOriginalImageList(List<String> itemOriginalImageList) {
        this.itemOriginalImageList = itemOriginalImageList;
    }

    public List<String> getItemNormalImageList() {
        return itemNormalImageList;
    }

    public void setItemNormalImageList(List<String> itemNormalImageList) {
        this.itemNormalImageList = itemNormalImageList;
    }

    public List<String> getItemThumbnailImageList() {
        return itemThumbnailImageList;
    }

    public void setItemThumbnailImageList(List<String> itemThumbnailImageList) {
        this.itemThumbnailImageList = itemThumbnailImageList;
    }

    public Map<Integer, String> getItemDetailImageMap() {
        return itemDetailImageMap;
    }

    public void setItemDetailImageMap(Map<Integer, String> itemDetailImageMap) {
        this.itemDetailImageMap = itemDetailImageMap;
    }
}
