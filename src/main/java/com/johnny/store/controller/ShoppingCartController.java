package com.johnny.store.controller;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.ShoppingCartDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 13425 on 2018/1/29.
 */
@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @RequestMapping(value = "/api/shoppingCart/{pageNumber}/{pageSize}/{customerID}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("customerID") int customerID,
                                  @PathVariable("status") String status){
        return shoppingCartServiceImpl.findList(pageNumber, pageSize, customerID, status);
    }

    @RequestMapping(value = "/api/shoppingCart/customer/{customerID}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("customerID") int customerID, @PathVariable("status") String status){
        return shoppingCartServiceImpl.findList4Customer(customerID, status);
    }

    @RequestMapping(value="/api/shoppingCart", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.change(dto);
    }


    @RequestMapping(value="/api/shoppingCart/customer/resetStatus", method = RequestMethod.PUT)
    public UnifiedResponse resetStatus(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.resetStatus(dto);
    }

    @RequestMapping(value="/api/shoppingCart/status", method = RequestMethod.PUT)
    public UnifiedResponse changeStatus(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.changeStatus(dto);
    }

    @RequestMapping(value="/api/shoppingCart", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/shoppingCart/{shoppingCartId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("shoppingCartId") int shoppingCartId){
        return shoppingCartServiceImpl.delete(shoppingCartId);
    }
}
