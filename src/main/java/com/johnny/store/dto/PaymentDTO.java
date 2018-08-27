package com.johnny.store.dto;

import com.johnny.store.enums.PaymentMethodEnum;

public class PaymentDTO {
    private PaymentMethodEnum paymentMethodEnum;
    private OrderPaymentDTO orderPayment;

    public PaymentMethodEnum getPaymentMethodEnum() {
        return paymentMethodEnum;
    }

    public void setPaymentMethodEnum(PaymentMethodEnum paymentMethodEnum) {
        this.paymentMethodEnum = paymentMethodEnum;
    }

    public OrderPaymentDTO getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(OrderPaymentDTO orderPayment) {
        this.orderPayment = orderPayment;
    }
}
