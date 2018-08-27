package com.johnny.store.service.impl;

import com.johnny.store.dto.PaymentDTO;
import com.johnny.store.manager.AliPayManager;
import com.johnny.store.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment(PaymentDTO dto) {
        String result = "";
        try{
            switch (dto.getPaymentMethodEnum()){
                case aliPay:
                    result = new AliPayManager().payment(dto.getOrderPayment());
                    break;
                case wxPay:
                    break;
            }
        }catch (Exception ex){
            String error = ex.toString();
        }
        return result;
    }
}
