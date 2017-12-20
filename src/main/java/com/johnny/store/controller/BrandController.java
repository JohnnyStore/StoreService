package com.johnny.store.controller;

import com.johnny.store.dto.BrandDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品品牌yangyajing
 */
@RestController
public class BrandController {
    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @RequestMapping(value = "/api/brand", method = RequestMethod.GET)
    public UnifiedResponse getAllBrand(){
        return brandServiceImpl.findList();
    }

    @RequestMapping(value = "/api/brand/{brandId}", method = RequestMethod.GET)
    public UnifiedResponse getBrand(@PathVariable("brandId") int brandId){
        return brandServiceImpl.find(brandId);
    }

    @RequestMapping(value = "/api/brand/exist/{brandName}", method = RequestMethod.GET)
    public UnifiedResponse checkBrandExist(@PathVariable("brandName") String brandName){
        return brandServiceImpl.existCheck(brandName);
    }

    @RequestMapping(value="/api/brand", method = RequestMethod.POST)
    public UnifiedResponse addBrand(@RequestBody BrandDTO brandDTO){
        return brandServiceImpl.add(brandDTO);
    }

    @RequestMapping(value="/api/brand", method = RequestMethod.PUT)
    public UnifiedResponse changeBrand(@RequestBody BrandDTO brandDTO){
        return brandServiceImpl.change(brandDTO);
    }

    @RequestMapping(value="/api/brand/{brandId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteBrand(@PathVariable("brandId") int brandId){
        return brandServiceImpl.delete(brandId);
    }
}