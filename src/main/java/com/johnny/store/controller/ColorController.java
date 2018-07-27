package com.johnny.store.controller;

import com.johnny.store.dto.ColorDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品颜色
 */
@RestController
public class ColorController {
    @Autowired
    private ColorServiceImpl colorServiceImpl;

    @RequestMapping(value = "/api/color/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllColor(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return colorServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/color/item/{itemID}/{seriesID}", method = RequestMethod.GET)
    public UnifiedResponse getItemColor(@PathVariable("itemID") int itemID,@PathVariable("seriesID") int seriesID){
        return colorServiceImpl.findListOfSeries(itemID, seriesID);
    }

    @RequestMapping(value = "/api/color/{colorId}", method = RequestMethod.GET)
    public UnifiedResponse getColor(@PathVariable("colorId") int colorId){
        return colorServiceImpl.find(colorId);
    }

    @RequestMapping(value = "/api/color/exist/{colorName}", method = RequestMethod.GET)
    public UnifiedResponse checkColorExist(@PathVariable("colorName") String colorName){
        return colorServiceImpl.existCheck(colorName);
    }

    /**
     * 添加新颜色
     * @param colorDTO
     * @return
     */
    @RequestMapping(value="/api/color", method = RequestMethod.POST)
    public UnifiedResponse addColor(@RequestBody ColorDTO colorDTO){
        return colorServiceImpl.add(colorDTO);
    }

    @RequestMapping(value="/api/color", method = RequestMethod.PUT)
    public UnifiedResponse changeColor(@RequestBody ColorDTO colorDTO){
        return colorServiceImpl.change(colorDTO);
    }

    @RequestMapping(value="/api/color/{colorId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteColor(@PathVariable("colorId") int colorId){
        return colorServiceImpl.delete(colorId);
    }
}
