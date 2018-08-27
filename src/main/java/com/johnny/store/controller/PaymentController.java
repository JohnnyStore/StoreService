package com.johnny.store.controller;

import com.johnny.store.common.JsonUtils;
import com.johnny.store.dto.OrderPaymentDTO;
import com.johnny.store.dto.PaymentDTO;
import com.johnny.store.enums.PaymentMethodEnum;
import com.johnny.store.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;

    @RequestMapping(value="/api/order/payment", method = RequestMethod.POST)
    public String payment(@RequestBody PaymentDTO dto){
        return paymentService.payment(dto);
    }

    @RequestMapping(value = "/api/payment/notify/aliPay", method = RequestMethod.GET)
    public String aliPayNotify(HttpServletResponse response, HttpServletRequest request){
        try{
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "GBK");
            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "GBK");
            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "GBK");
            // 交易说明
            String cus = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");
            // 交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "GBK");
            if (trade_status.equals("TRADE_SUCCESS")) {
                return "success";
            }
            return "failed";
        }catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value="/api/payment/getReq/{method}", method = RequestMethod.GET)
    public String getJson(@PathVariable("method") String method){
        PaymentDTO paymentDTO = new PaymentDTO();
        OrderPaymentDTO orderPaymentDTO = new OrderPaymentDTO();
        orderPaymentDTO.setOrderID(123456789);
        orderPaymentDTO.setOrderAmount(99.99);
        orderPaymentDTO.setSubject("商品描述");
        orderPaymentDTO.setBody("商品详细描述");
        orderPaymentDTO.setLoginUser("Johnny");

        paymentDTO.setPaymentMethodEnum(PaymentMethodEnum.aliPay);
        paymentDTO.setOrderPayment(orderPaymentDTO);

        String json = JsonUtils.getJsonStr(paymentDTO);
        return json;
    }
}
