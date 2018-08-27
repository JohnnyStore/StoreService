package com.johnny.store.controller;

import com.johnny.store.dto.CompanyInfoDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.CompanyInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyInfoController {
    @Autowired
    private CompanyInfoServiceImpl companyInfoService;

    @RequestMapping(value = "/api/companyInfo/{infoID}", method = RequestMethod.GET)
    public UnifiedResponse getAllColor(@PathVariable("infoID") int infoID){
        return companyInfoService.find(infoID);
    }

    @RequestMapping(value="/api/companyInfo", method = RequestMethod.POST)
    public UnifiedResponse addColor(@RequestBody CompanyInfoDTO dto){
        return companyInfoService.save(dto);
    }
}
