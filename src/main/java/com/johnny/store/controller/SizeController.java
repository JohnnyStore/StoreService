package com.johnny.store.controller;

import com.johnny.store.dto.SizeDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品尺码
 */
@RestController
public class SizeController {
    @Autowired
    private SizeServiceImpl sizeServiceImpl;

    @RequestMapping(value = "/api/size/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllSize(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return sizeServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/size/{sizeId}", method = RequestMethod.GET)
    public UnifiedResponse getSize(@PathVariable("sizeId") int sizeId){
        return sizeServiceImpl.find(sizeId);
    }

    @RequestMapping(value = "/api/size/exist/{sizeName}", method = RequestMethod.GET)
    public UnifiedResponse checkSizeExist(@PathVariable("sizeName") String sizeName){
        return sizeServiceImpl.existCheck(sizeName);
    }

    /**
     * 添加新尺码
     * @param sizeDTO
     * @return
     */
    @RequestMapping(value="/api/size", method = RequestMethod.POST)
    public UnifiedResponse addSize(@RequestBody SizeDTO sizeDTO){
        return sizeServiceImpl.add(sizeDTO);
    }

    @RequestMapping(value="/api/size", method = RequestMethod.PUT)
    public UnifiedResponse changeSize(@RequestBody SizeDTO sizeDTO){
        return sizeServiceImpl.change(sizeDTO);
    }

    @RequestMapping(value="/api/size/{sizeId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteSize(@PathVariable("sizeId") int sizeId){
        return sizeServiceImpl.delete(sizeId);
    }
}
