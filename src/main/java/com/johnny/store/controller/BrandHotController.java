package com.johnny.store.controller;
import com.johnny.store.dto.BrandHotDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.BrandHotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandHotController {
    @Autowired
    private BrandHotServiceImpl brandHotServiceImpl;

    @RequestMapping(value = "/api/brandHot/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return brandHotServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/brandHot/{brandHotId}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("brandHotId") int brandHotId){
        return brandHotServiceImpl.find(brandHotId);
    }

    @RequestMapping(value="/api/brandHot", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody BrandHotDTO dto){
        return brandHotServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/brandHot", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody BrandHotDTO dto){
        return brandHotServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/brandHot/{brandHotId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("brandHotId") int brandHotId){
        return brandHotServiceImpl.delete(brandHotId);
    }
}
