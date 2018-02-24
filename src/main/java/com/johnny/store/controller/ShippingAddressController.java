package com.johnny.store.controller;

import com.johnny.store.dto.ShippingAddressDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ShippingAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShippingAddressController {
    @Autowired
    private ShippingAddressServiceImpl shippingAddressServiceImpl;

    @RequestMapping(value = "/api/shippingAddress/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllColor(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return shippingAddressServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/shippingAddress/{shippingAddressId}", method = RequestMethod.GET)
    public UnifiedResponse getColor(@PathVariable("shippingAddressId") int shippingAddressId){
        return shippingAddressServiceImpl.find(shippingAddressId);
    }

    @RequestMapping(value="/api/shippingAddress", method = RequestMethod.POST)
    public UnifiedResponse addColor(@RequestBody ShippingAddressDTO dto){
        return shippingAddressServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/shippingAddress", method = RequestMethod.PUT)
    public UnifiedResponse changeColor(@RequestBody ShippingAddressDTO dto){
        return shippingAddressServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/shippingAddress/{shippingAddressId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteColor(@PathVariable("shippingAddressId") int shippingAddressId){
        return shippingAddressServiceImpl.delete(shippingAddressId);
    }
}
