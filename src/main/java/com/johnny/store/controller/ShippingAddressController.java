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
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return shippingAddressServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/shippingAddress/{shippingAddressId}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("shippingAddressId") int shippingAddressId){
        return shippingAddressServiceImpl.find(shippingAddressId);
    }

    @RequestMapping(value = "/api/shippingAddress/customer/{customerID}", method = RequestMethod.GET)
    public UnifiedResponse get4Customer(@PathVariable("customerID") int customerID){
        return shippingAddressServiceImpl.find4Customer(customerID);
    }

    @RequestMapping(value="/api/shippingAddress", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ShippingAddressDTO dto){
        return shippingAddressServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/shippingAddress/change", method = RequestMethod.PUT)
    public UnifiedResponse changeInfo(@RequestBody ShippingAddressDTO dto){
        return shippingAddressServiceImpl.changeInfo(dto);
    }

    @RequestMapping(value="/api/shippingAddress", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ShippingAddressDTO dto){
        return shippingAddressServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/shippingAddress/{shippingAddressId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("shippingAddressId") int shippingAddressId){
        return shippingAddressServiceImpl.delete(shippingAddressId);
    }
}
