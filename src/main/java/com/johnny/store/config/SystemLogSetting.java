package com.johnny.store.config;

public class SystemLogSetting {
    private String priority;
    private String errorTime;
    private String errorCode;
    private String errorType;
    private String errorOption;
    private String errorMessage;
    private String errorDetail;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorOption() {
        return errorOption;
    }

    public void setErrorOption(String errorOption) {
        this.errorOption = errorOption;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
