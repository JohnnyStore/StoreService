package com.johnny.store.manager;

import com.johnny.store.vo.PaymentVO;

public class PaymentManager {
    public String payment(PaymentVO paymentVO){

        return "success";
    }

    private String aliPay(){

        return "success";
    }

    private String wxPay(){

        return "success";
    }
}
