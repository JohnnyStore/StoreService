package com.johnny.store.config;

import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;

public class ResponseSetting {
    private String responseCode;
    private String responseMessage;
    private ResponseTypeEnum responseType;
    private boolean result;
    private ResponseOptionEnum responseOption;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseTypeEnum getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseTypeEnum responseType) {
        this.responseType = responseType;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ResponseOptionEnum getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(ResponseOptionEnum responseOption) {
        this.responseOption = responseOption;
    }
}
