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

    @RequestMapping(value = "/api/shoppingCart/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return shoppingCartServiceImpl.findList(pageNumber, pageSize);
    }

//    @RequestMapping(value = "/api/shoppingCart", method = RequestMethod.POST)
//    public UnifiedResponse add(@RequestBody ShoppingCartDTO dto) {
//        return shoppingCartServiceImpl.find(dto);
//    }
//
//    @RequestMapping(value="/api/shoppingCart", method = RequestMethod.POST)
//    public UnifiedResponse add(@RequestBody ShoppingCartDTO dto){
//        return shoppingCartServiceImpl.add(dto);
//    }

    @RequestMapping(value = "/api/shoppingCart/{shoppingCartId}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("shoppingCartId") int shoppingCartId){
        return shoppingCartServiceImpl.find(shoppingCartId);
    }

    @RequestMapping(value="/api/shoppingCart", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ShoppingCartDTO dto){
        return shoppingCartServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/shoppingCart/{shoppingCartId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("shoppingCartId") int shoppingCartId){
        return shoppingCartServiceImpl.delete(shoppingCartId);
    }
}
