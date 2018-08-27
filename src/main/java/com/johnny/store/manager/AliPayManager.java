package com.johnny.store.manager;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.johnny.store.config.AliPayConfig;
import com.johnny.store.dto.OrderPaymentDTO;

public class AliPayManager {

    public String payment(OrderPaymentDTO orderPayment) throws AlipayApiException {
        AliPayConfig aliPayConfig = new AliPayConfig();
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getServiceUrl(), aliPayConfig.getAppId(), aliPayConfig.getPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(), aliPayConfig.getPublicKey(), aliPayConfig.getSignType());

        // 设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());
        aliPayRequest.setReturnUrl(aliPayConfig.getReturnUrl());
        aliPayRequest.setBizContent(
                "{" +
                    "\"out_trade_no\":\"" + orderPayment.getOrderID() + "\"," +
                    "\"total_amount\":\"" + orderPayment.getOrderAmount() + "\"," +
                    "\"subject\":\"" + orderPayment.getSubject() + "\"," +
                    "\"body\":\"" + orderPayment.getBody() + "\"," +
                    "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"" +
                "}");

        // 支付请求
        String result = alipayClient.pageExecute(aliPayRequest).getBody();
        return result;
    }

}
