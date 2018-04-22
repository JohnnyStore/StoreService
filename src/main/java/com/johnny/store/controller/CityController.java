package com.johnny.store.controller;

import com.johnny.store.dto.CityDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityServiceImpl cityServiceImpl;

    @RequestMapping(value = "api/city/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public UnifiedResponse getAllCity(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return cityServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "api/city/{cityId}",method = RequestMethod.GET)
    public UnifiedResponse getCity(@PathVariable("cityId") int cityId){
        return cityServiceImpl.find(cityId);
    }

    @RequestMapping(value = "api/city4Province/{countryID}/{provinceID}",method = RequestMethod.GET)
    public UnifiedResponse getCity(@PathVariable("countryID") int countryID, @PathVariable("provinceID") int provinceID){
        return cityServiceImpl.find(countryID, provinceID);
    }

    @RequestMapping(value = "api/city/exist/{cityName}",method = RequestMethod.GET)
    public UnifiedResponse checkCityExist(@PathVariable("cityName") String cityName){
        return cityServiceImpl.existCheck(cityName);
    }

    @RequestMapping(value = "api/city",method = RequestMethod.POST)
    public UnifiedResponse addCity(@RequestBody CityDTO cityDTO){
        return cityServiceImpl.add(cityDTO);
    }

    @RequestMapping(value = "api/city",method = RequestMethod.PUT)
    public UnifiedResponse changeCity(@RequestBody CityDTO cityDTO){
        return cityServiceImpl.change(cityDTO);
    }

    @RequestMapping(value = "api/city/{cityId}",method = RequestMethod.DELETE)
    public UnifiedResponse deleteCity(@PathVariable int cityId){
        return cityServiceImpl.delete(cityId);
    }
}
