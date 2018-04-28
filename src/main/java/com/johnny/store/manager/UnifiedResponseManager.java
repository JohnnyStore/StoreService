package com.johnny.store.manager;

import com.johnny.store.common.LogUtils;
import com.johnny.store.config.ResponseSetting;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.OrderHistoryResponse;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;

/**
 * 统一返回对象
 */
public class UnifiedResponseManager {
    public static <T> UnifiedResponse buildSuccessResponse(T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setTotalCount(data != null? 1 : 0);
            unifiedResponse.setResponseData(data);

            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponse(String responseCode, T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(responseCode);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setTotalCount(data != null? 1 : 0);
            unifiedResponse.setResponseData(data);

            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponse(int totalCount, T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setTotalCount(totalCount);
            unifiedResponse.setResponseData(data);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> OrderHistoryResponse buildSuccessResponse(int orderCount, int toPayOrderCount, int toReceiveOrderCount, int toReviewOrderCount, T data){
        try{
            OrderHistoryResponse<T> unifiedResponse = new OrderHistoryResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setTotalCount(orderCount);
            unifiedResponse.setToPayOrderCount(toPayOrderCount);
            unifiedResponse.setToReceiveOrderCount(toReceiveOrderCount);
            unifiedResponse.setToReviewOrderCount(toReviewOrderCount);
            unifiedResponse.setResponseData(data);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorOrderHistoryResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponse(int affectCount){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setAffectCount(affectCount);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildSuccessResponseWithID(int affectCount, T data){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(ResponseCodeConsts.SUCCESS);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setAffectCount(affectCount);
            unifiedResponse.setResponseData(data);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    public static <T> UnifiedResponse buildFailedResponse(String responseCode){
        try{
            UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
            ResponseSetting responseSetting = ConfigManager.getResponseSetting(responseCode);
            unifiedResponse.setResponseCode(responseSetting.getResponseCode());
            unifiedResponse.setResponseMessage(responseSetting.getResponseMessage());
            unifiedResponse.setResult(responseSetting.isResult());
            unifiedResponse.setResponseType(responseSetting.getResponseType());
            unifiedResponse.setResponseOption(responseSetting.getResponseOption());
            unifiedResponse.setResponseData(null);
            return unifiedResponse;
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return buildErrorResponse(ResponseCodeConsts.BuildResponseException);
        }
    }

    private static <T> UnifiedResponse buildErrorResponse(String responseCode){
        UnifiedResponse<T> unifiedResponse = new UnifiedResponse<>();
        unifiedResponse.setResponseCode(responseCode);
        unifiedResponse.setResponseMessage("build unified response exception");
        unifiedResponse.setResult(false);
        unifiedResponse.setResponseType(ResponseTypeEnum.Exception);
        unifiedResponse.setResponseOption(ResponseOptionEnum.Admin);
        unifiedResponse.setResponseData(null);
        return unifiedResponse;
    }

    public static <T> OrderHistoryResponse buildErrorOrderHistoryResponse(String responseCode){
        OrderHistoryResponse<T> unifiedResponse = new OrderHistoryResponse<>();
        unifiedResponse.setResponseCode(responseCode);
        unifiedResponse.setResponseMessage("build unified response exception");
        unifiedResponse.setResult(false);
        unifiedResponse.setResponseType(ResponseTypeEnum.Exception);
        unifiedResponse.setResponseOption(ResponseOptionEnum.Admin);
        unifiedResponse.setResponseData(null);
        return unifiedResponse;
    }
}