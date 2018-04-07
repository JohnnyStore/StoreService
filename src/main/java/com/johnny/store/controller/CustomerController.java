package com.johnny.store.controller;

import com.johnny.store.dto.CustomerDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.dto.VerificationCodeDTO;
import com.johnny.store.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "api/customer/{pageNumber}/{pageSize}/{cellphone}/{status}",method = RequestMethod.GET)
    public UnifiedResponse getCustomerList(@PathVariable("pageNumber") int pageNumber,
                                           @PathVariable("pageSize") int pageSize,
                                           @PathVariable("cellphone") String cellphone,
                                           @PathVariable("status") String status){
        return customerServiceImpl.findList(pageNumber, pageSize, cellphone, status);
    }

    @RequestMapping(value = "api/customer/{customerID}",method = RequestMethod.GET)
    public UnifiedResponse getCustomer(@PathVariable("customerID") int customerID){
        return customerServiceImpl.find(customerID);
    }

    @RequestMapping(value = "api/customer/account/{account}",method = RequestMethod.GET)
    public UnifiedResponse getCustomerByAccount(@PathVariable("account") String account){
        return customerServiceImpl.findByAccount(account);
    }

    @RequestMapping(value = "api/customer/cellphone/{cellphone}",method = RequestMethod.GET)
    public UnifiedResponse getCustomerByCellphone(@PathVariable("cellphone") String cellphone){
        return customerServiceImpl.findByCellphone(cellphone);
    }

    @RequestMapping(value = "api/customer/email/{email}",method = RequestMethod.GET)
    public UnifiedResponse getCustomerByEmail(@PathVariable("email") String email){
        return customerServiceImpl.findByEmail(email);
    }

    @RequestMapping(value = "api/customer/login/{userName}/{password}",method = RequestMethod.GET)
    public UnifiedResponse login(@PathVariable("userName") String userName, @PathVariable("password") String password){
        return customerServiceImpl.login(userName, password);
    }

    @RequestMapping(value="api/customer", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.add(customerDTO);
    }

    @RequestMapping(value = "api/customer/changeStatus",method = RequestMethod.PUT)
    public UnifiedResponse changeCustomerStatus(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.changeStatus(customerDTO);
    }

    @RequestMapping(value = "api/customer/changePassword",method = RequestMethod.PUT)
    public UnifiedResponse updateCustomerPassword(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.updatePassword(customerDTO);
    }

    @RequestMapping(value = "api/customer/forgetPassword",method = RequestMethod.PUT)
    public UnifiedResponse changeCustomerPassword(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.changePassword(customerDTO);
    }

    @RequestMapping(value = "api/customer",method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody CustomerDTO customerDTO){
        return customerServiceImpl.change(customerDTO);
    }

    @RequestMapping(value="api/customer/{customerId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteBrand(@PathVariable("customerId") int customerId){
        return customerServiceImpl.delete(customerId);
    }
}

