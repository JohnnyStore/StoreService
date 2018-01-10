package com.johnny.store.controller;

import com.johnny.store.dto.ProvinceDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProvinceController {
    @Autowired
    private ProvinceServiceImpl provinceServiceImpl;

    @RequestMapping(value = "api/province/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public UnifiedResponse getAllProvince(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return provinceServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "api/province/{provinceID}",method = RequestMethod.GET)
    public UnifiedResponse getProvince(@PathVariable("provinceID") int provinceID){
        return provinceServiceImpl.find(provinceID);
    }

    @RequestMapping(value = "api/province/forCountry/{countryID}",method = RequestMethod.GET)
    public UnifiedResponse getProvinceForCountry(@PathVariable("countryID") int countryID){
        return provinceServiceImpl.findByCountry(countryID);
    }

    @RequestMapping(value = "api/province/exist/{provinceName}",method = RequestMethod.GET)
    public UnifiedResponse checkProvinceExist(@PathVariable("provinceName") String provinceName){
        return provinceServiceImpl.existCheck(provinceName);
    }

    @RequestMapping(value = "api/province",method = RequestMethod.POST)
    public UnifiedResponse addProvince(@RequestBody ProvinceDTO provinceDTO){
        return provinceServiceImpl.add(provinceDTO);
    }

    @RequestMapping(value = "api/province",method = RequestMethod.PUT)
    public UnifiedResponse changeProvince(@RequestBody ProvinceDTO provinceDTO){
        return provinceServiceImpl.change(provinceDTO);
    }

    @RequestMapping(value = "api/province/{provinceID}",method = RequestMethod.DELETE)
    public UnifiedResponse deleteProvince(@PathVariable int provinceID){
        return provinceServiceImpl.delete(provinceID);
    }
}
