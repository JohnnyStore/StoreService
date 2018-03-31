package com.johnny.store.controller;

import com.johnny.store.dto.OrderDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping(value = "/api/order/{pageNumber}/{pageSize}/{cellphone}/{recentMonth}/{orderStatus}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("cellphone") String cellphone,
                                  @PathVariable("recentMonth") int recentMonth,
                                  @PathVariable("orderStatus") String orderStatus){
        return orderServiceImpl.findList(pageNumber, pageSize, cellphone, recentMonth, orderStatus);
    }

    @RequestMapping(value = "/api/order/{pageNumber}/{pageSize}/{customerId}/{orderStatus}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("customerId") int customerId,
                                  @PathVariable("orderStatus") String orderStatus){
        return orderServiceImpl.findList(pageNumber, pageSize, customerId, orderStatus);
    }

    @RequestMapping(value = "/api/order/{orderID}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("orderID") int orderID){
        return orderServiceImpl.find(orderID);
    }

    @RequestMapping(value="/api/order", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody OrderDTO dto){
        return orderServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/order/changeStatus", method = RequestMethod.PUT)
    public UnifiedResponse changeOrderStatus(@RequestBody OrderDTO dto){
        return orderServiceImpl.changeOrderStatus(dto);
    }

    @RequestMapping(value="/api/order/changeExpressInfo", method = RequestMethod.PUT)
    public UnifiedResponse updateTrackingInfo(@RequestBody OrderDTO dto){
        return orderServiceImpl.updateTrackingInfo(dto);
    }
}
