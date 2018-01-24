package com.johnny.store.vo;

/**
 * Created by 13425 on 2017/12/16.
 */
public class ItemVO {
    private int itemID;
    private int brandID;
    private String brandCN;
    private String brandEN;
    private int categoryID;
    private String categoryCN;
    private String categoryEN;
    private int subCategoryID;
    private String subCategoryCN;
    private String subCategoryEN;
    private int seriesID;
    private String itemSeriesCN;
    private String itemSeriesEN;
    private String itemCode;
    private String itemNameCN;
    private String itemNameEN;
    private String itemImageUrl;
    private double unitPrice4RMB;
    private double promotionPrice4RMB;
    private double unitPrice4USD;
    private double promotionPrice4USD;
    private float rate;
    private int colorID;
    private String colorCN;
    private String colorEN;
    private int sizeID;
    private String sizeCN;
    private String sizeEN;
    private int materialID;
    private String materialCN;
    private String materialEN;
    private int madeInID;
    private String madeInCN;
    private String madeInEN;
    private String itemLength;
    private String adjustLength;
    private String suitablePetCN;
    private String suitablePetEN;
    private String itemShortDescriptionCN;
    private String itemShortDescriptionEN;
    private String itemDescriptionCN;
    private String itemDescriptionEN;
    private String itemStatus;
    private String itemStatusText;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getMadeInID() {
        return madeInID;
    }

    public void setMadeInID(int madeInID) {
        this.madeInID = madeInID;
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

    public String getBrandCN() {
        return brandCN;
    }

    public void setBrandCN(String brandCN) {
        this.brandCN = brandCN;
    }

    public String getBrandEN() {
        return brandEN;
    }

    public void setBrandEN(String brandEN) {
        this.brandEN = brandEN;
    }

    public String getCategoryCN() {
        return categoryCN;
    }

    public void setCategoryCN(String categoryCN) {
        this.categoryCN = categoryCN;
    }

    public String getCategoryEN() {
        return categoryEN;
    }

    public void setCategoryEN(String categoryEN) {
        this.categoryEN = categoryEN;
    }

    public String getSubCategoryCN() {
        return subCategoryCN;
    }

    public void setSubCategoryCN(String subCategoryCN) {
        this.subCategoryCN = subCategoryCN;
    }

    public String getSubCategoryEN() {
        return subCategoryEN;
    }

    public void setSubCategoryEN(String subCategoryEN) {
        this.subCategoryEN = subCategoryEN;
    }

    public String getItemSeriesCN() {
        return itemSeriesCN;
    }

    public void setItemSeriesCN(String itemSeriesCN) {
        this.itemSeriesCN = itemSeriesCN;
    }

    public String getItemSeriesEN() {
        return itemSeriesEN;
    }

    public void setItemSeriesEN(String itemSeriesEN) {
        this.itemSeriesEN = itemSeriesEN;
    }

    public String getColorCN() {
        return colorCN;
    }

    public void setColorCN(String colorCN) {
        this.colorCN = colorCN;
    }

    public String getColorEN() {
        return colorEN;
    }

    public void setColorEN(String colorEN) {
        this.colorEN = colorEN;
    }

    public String getSizeCN() {
        return sizeCN;
    }

    public void setSizeCN(String sizeCN) {
        this.sizeCN = sizeCN;
    }

    public String getSizeEN() {
        return sizeEN;
    }

    public void setSizeEN(String sizeEN) {
        this.sizeEN = sizeEN;
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

    public String getMadeInCN() {
        return madeInCN;
    }

    public void setMadeInCN(String madeInCN) {
        this.madeInCN = madeInCN;
    }

    public String getMadeInEN() {
        return madeInEN;
    }

    public void setMadeInEN(String madeInEN) {
        this.madeInEN = madeInEN;
    }

    public String getItemStatusText() {
        return itemStatusText;
    }

    public void setItemStatusText(String itemStatusText) {
        this.itemStatusText = itemStatusText;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }
}
