package com.johnny.store.dto;

import java.util.List;
import java.util.Map;

public class ItemDTO {
    private int itemID;
    private int brandID;
    private int categoryID;
    private int subCategoryID;
    private int itemGroupID;
    private int seriesID;
    private String itemCode;
    private double unitPrice4RMB;
    private double promotionPrice4RMB;
    private double unitPrice4USD;
    private double promotionPrice4USD;
    private float rate;
    private int colorID;
    private int sizeID;
    private String itemMaterial;
    private String itemMaterialName;
    private int madeInID;
    private String itemLength;
    private String adjustLength;
    private String suitablePetCN;
    private String suitablePetEN;
    private String itemShortDescriptionCN;
    private String itemShortDescriptionEN;
    private String itemDescriptionCN;
    private String itemDescriptionEN;
    private String itemStatus;
    private Boolean showInListPage;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitPrice4RMB() {
        return unitPrice4RMB;
    }

    public void setUnitPrice4RMB(double unitPrice4RMB) {
        this.unitPrice4RMB = unitPrice4RMB;
    }

    public double getPromotionPrice4RMB() {
        return promotionPrice4RMB;
    }

    public void setPromotionPrice4RMB(double promotionPrice4RMB) {
        this.promotionPrice4RMB = promotionPrice4RMB;
    }

    public double getUnitPrice4USD() {
        return unitPrice4USD;
    }

    public void setUnitPrice4USD(double unitPrice4USD) {
        this.unitPrice4USD = unitPrice4USD;
    }

    public double getPromotionPrice4USD() {
        return promotionPrice4USD;
    }

    public void setPromotionPrice4USD(double promotionPrice4USD) {
        this.promotionPrice4USD = promotionPrice4USD;
    }

    public String getItemLength() {
        return itemLength;
    }

    public void setItemLength(String itemLength) {
        this.itemLength = itemLength;
    }

    public String getAdjustLength() {
        return adjustLength;
    }

    public void setAdjustLength(String adjustLength) {
        this.adjustLength = adjustLength;
    }

    public int getItemGroupID() {
        return itemGroupID;
    }

    public void setItemGroupID(int itemGroupID) {
        this.itemGroupID = itemGroupID;
    }

    public String getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public String getItemMaterialName() {
        return itemMaterialName;
    }

    public void setItemMaterialName(String itemMaterialName) {
        this.itemMaterialName = itemMaterialName;
    }

    public Boolean getShowInListPage() {
        return showInListPage;
    }

    public void setShowInListPage(Boolean showInListPage) {
        this.showInListPage = showInListPage;
    }
}
