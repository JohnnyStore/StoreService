package com.johnny.store.controller;

import com.johnny.store.dto.CustomerDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "api/customer/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public UnifiedResponse getCustomerList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return customerServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "api/customer/{customerID}",method = RequestMethod.GET)
    public UnifiedResponse getCustomer(@PathVariable("customerID") int customerID){
        return customerServiceImpl.find(customerID);
    }

    @RequestMapping(value = "api/customer",method = RequestMethod.PUT)
    public UnifiedResponse changeCustomerStatus(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.change(customerDTO);
    }

}

