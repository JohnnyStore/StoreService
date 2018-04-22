package com.johnny.store.vo;

public class ShippingAddressVO {
    private int shippingID;
    private int customerID;
    private int shippingCountryID;
    private CountryVO countryVO;
    private int shippingProvinceID;
    private ProvinceVO provinceVO;
    private int shippingCityID;
    private CityVO cityVO;
    private String shippingStreet;
    private String consignee;
    private String cellphone;
    private boolean defaultAddress;
    private String inUser;
    private String inDate;
    private String lastEditUser;
    private String lastEditDate;

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShippingCountryID() {
        return shippingCountryID;
    }

    public void setShippingCountryID(int shippingCountryID) {
        this.shippingCountryID = shippingCountryID;
    }

    public int getShippingProvinceID() {
        return shippingProvinceID;
    }

    public void setShippingProvinceID(int shippingProvinceID) {
        this.shippingProvinceID = shippingProvinceID;
    }

    public int getShippingCityID() {
        return shippingCityID;
    }

    public void setShippingCityID(int shippingCityID) {
        this.shippingCityID = shippingCityID;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getInUser() {
        return inUser;
    }

    public void setInUser(String inUser) {
        this.inUser = inUser;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser) {
        this.lastEditUser = lastEditUser;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public CountryVO getCountryVO() {
        return countryVO;
    }

    public void setCountryVO(CountryVO countryVO) {
        this.countryVO = countryVO;
    }

    public ProvinceVO getProvinceVO() {
        return provinceVO;
    }

    public void setProvinceVO(ProvinceVO provinceVO) {
        this.provinceVO = provinceVO;
    }

    public CityVO getCityVO() {
        return cityVO;
    }

    public void setCityVO(CityVO cityVO) {
        this.cityVO = cityVO;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
