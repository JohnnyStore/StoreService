package com.johnny.store.controller;

import com.johnny.store.dto.AdministratorDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员信息维护
 */
@RestController
public class AdministratorController {
    @Autowired
    private AdministratorServiceImpl administratorServiceImpl;

    @RequestMapping(value = "/api/administrator/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllAdministrator(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return administratorServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/administrator/{administratorId}", method = RequestMethod.GET)
    public UnifiedResponse getAdministrator(@PathVariable("administratorId") int administratorId){
        return administratorServiceImpl.find(administratorId);
    }

    @RequestMapping(value = "/api/administrator/exist/name/{administratorName}", method = RequestMethod.GET)
    public UnifiedResponse checkAdministratorNameExist(@PathVariable("administratorName") String administratorName){
        return administratorServiceImpl.existCheck(administratorName);
    }

    @RequestMapping(value = "/api/administrator/exist/account/{account}", method = RequestMethod.GET)
    public UnifiedResponse checkAccountExist(@PathVariable("account") String account){
        return administratorServiceImpl.checkAccountIsExists(account);
    }

    @RequestMapping(value = "/api/administrator/exist/cellphone/{cellphone}", method = RequestMethod.GET)
    public UnifiedResponse checkCellphoneIsExists(@PathVariable("cellphone") String cellphone){
        return administratorServiceImpl.checkCellphoneIsExists(cellphone);
    }

    @RequestMapping(value = "/api/administrator/exist/email/{email:.+}", method = RequestMethod.GET)
    public UnifiedResponse checkEmailIsExists(@PathVariable("email") String email){
        return administratorServiceImpl.checkEmailIsExists(email);
    }

    @RequestMapping(value = "/api/administrator/login/{userName}/{password}", method = RequestMethod.GET)
    public UnifiedResponse login(@PathVariable("userName") String userName, @PathVariable("password") String password){
        return administratorServiceImpl.login(userName, password);
    }

    @RequestMapping(value="/api/administrator", method = RequestMethod.POST)
    public UnifiedResponse addAdministrator(@RequestBody AdministratorDTO administratorDTO){
        return administratorServiceImpl.add(administratorDTO);
    }

    @RequestMapping(value="/api/administrator", method = RequestMethod.PUT)
    public UnifiedResponse changeAdministrator(@RequestBody AdministratorDTO administratorDTO){
        return administratorServiceImpl.change(administratorDTO);
    }

    @RequestMapping(value="/api/administrator/approve", method = RequestMethod.PUT)
    public UnifiedResponse approveRegister(@RequestBody AdministratorDTO administratorDTO){
        return administratorServiceImpl.approve(administratorDTO);
    }

    @RequestMapping(value="/api/administrator/{administratorId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteAdministrator(@PathVariable("administratorId") int administratorId){
        return administratorServiceImpl.delete(administratorId);
    }
}