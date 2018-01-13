package com.johnny.store.controller;

import com.johnny.store.dto.ExpressCompanyDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ExpressCompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpressCompanyController {
    @Autowired
    private ExpressCompanyServiceImpl expressCompanyServiceImpl;

    @RequestMapping(value = "/api/expressCompany/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllExpressCompany(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return expressCompanyServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/expressCompany/{companyId}", method = RequestMethod.GET)
    public UnifiedResponse getExpressCompany(@PathVariable("companyId") int companyId){
        return expressCompanyServiceImpl.find(companyId);
    }

    @RequestMapping(value = "/api/expressCompany/exist/{companyName}", method = RequestMethod.GET)
    public UnifiedResponse checkExpressCompanyExist(@PathVariable("companyName") String companyName){
        return expressCompanyServiceImpl.existCheck(companyName);
    }

    @RequestMapping(value="/api/expressCompany", method = RequestMethod.POST)
    public UnifiedResponse addExpressCompany(@RequestBody ExpressCompanyDTO expressCompanyDTO){
        return expressCompanyServiceImpl.add(expressCompanyDTO);
    }

    @RequestMapping(value="/api/expressCompany", method = RequestMethod.PUT)
    public UnifiedResponse changeExpressCompany(@RequestBody ExpressCompanyDTO expressCompanyDTO){
        return expressCompanyServiceImpl.change(expressCompanyDTO);
    }

    @RequestMapping(value="/api/expressCompany/{companyId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteExpressCompany(@PathVariable("companyId") int companyId){
        return expressCompanyServiceImpl.delete(companyId);
    }
}
