package com.johnny.store.controller;

import com.johnny.store.dto.BrandHotDTO;
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

//    @RequestMapping(value = "/api/shoppingCart/condition/{customerId}/{status}", method = RequestMethod.GET)
//    public UnifiedResponse get(@PathVariable("customerId") int customerId, @PathVariable("status") String status){
//        return shoppingCartServiceImpl.find(customerId, status);
//    }

    @RequestMapping(value="/api/shoppingCart", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/shoppingCart/{shoppingCartId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("shoppingCartId") int shoppingCartId){
        return shoppingCartServiceImpl.delete(shoppingCartId);
    }
}
