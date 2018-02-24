package com.johnny.store.constant;

public class ResponseCodeConsts {
    public static final String SUCCESS = "1000";
    public static final String LOGIN_SUCCESS = "1001";
    public static final String LOGIN_FAILED = "1002";
    public static final String LOGIN_CHECKING = "1003";
    public static final String LOGIN_CHECKING_NOPASS = "1004";
    public static final String ACCOUNT_FROZEN = "1005";
    public static final String UserDataInvalid = "2F01";
    public static final String CanNotFindCustomer = "2F02";
    public static final String CanNotFindShippingAddress = "2F03";
    public static final String CanNotFindExpressCompany = "2F04";
    public static final String CanNotFindCountry = "2F05";
    public static final String CanNotFindProvince = "2F06";
    public static final String CanNotFindCity = "2F07";
    public static final String ConfigFileNotFound = "3E01";
    public static final String DatabaseAccessException = "3E02";
    public static final String InvokeMethodException = "3E03";
    public static final String InvokeSecurityException = "3E04";
    public static final String InvokeNoMethodException = "3E05";
    public static final String BuildResponseException = "3E98";
    public static final String UnKnownException = "3E99";
}
