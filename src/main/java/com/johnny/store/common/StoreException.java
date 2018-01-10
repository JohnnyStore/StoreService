package com.johnny.store.common;

import com.johnny.store.enums.PriorityEnum;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;
import java.util.Date;

public class StoreException extends Exception {
    private PriorityEnum priority;
    private Date errorTime;
    private String errorCode;
    private ResponseTypeEnum errorType;
    private ResponseOptionEnum errorOption;
    private String exMessage;
    private Exception ex;

    public StoreException(PriorityEnum priority,
                          Date errorTime,
                          String errorCode,
                          ResponseTypeEnum errorType,
                          ResponseOptionEnum errorOption,
                          String exMessage,
                          Exception ex){
        this.priority = priority;
        this.errorTime = errorTime;
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorOption = errorOption;
        this.exMessage = exMessage;
        this.ex = ex;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseTypeEnum getErrorType() {
        return errorType;
    }

    public void setErrorType(ResponseTypeEnum errorType) {
        this.errorType = errorType;
    }

    public ResponseOptionEnum getErrorOption() {
        return errorOption;
    }

    public void setErrorOption(ResponseOptionEnum errorOption) {
        this.errorOption = errorOption;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }
}
