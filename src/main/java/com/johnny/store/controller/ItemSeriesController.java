package com.johnny.store.controller;

import com.johnny.store.dto.ItemSeriesDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemSeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品系列
 */
@RestController
public class ItemSeriesController {
    @Autowired
    private ItemSeriesServiceImpl itemSeriesServiceImpl;

    @RequestMapping(value = "/api/itemSeries/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllItemSeries(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return itemSeriesServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/itemSeries/{seriesId}", method = RequestMethod.GET)
    public UnifiedResponse getItemSeries(@PathVariable("seriesId") int seriesId){
        return itemSeriesServiceImpl.find(seriesId);
    }

    @RequestMapping(value = "/api/itemSeries/exist/{itemSeriesName}", method = RequestMethod.GET)
    public UnifiedResponse checkItemSeriesExist(@PathVariable("itemSeriesName") String itemSeriesName){
        return itemSeriesServiceImpl.existCheck(itemSeriesName);
    }

    /**
     * 添加新商品系列
     * @param itemSeriesDTO
     * @return
     */
    @RequestMapping(value="/api/itemSeries", method = RequestMethod.POST)
    public UnifiedResponse addItemSeries(@RequestBody ItemSeriesDTO itemSeriesDTO){
        return itemSeriesServiceImpl.add(itemSeriesDTO);
    }

    @RequestMapping(value="/api/itemSeries", method = RequestMethod.PUT)
    public UnifiedResponse changeItemSeries(@RequestBody ItemSeriesDTO itemSeriesDTO){
        return itemSeriesServiceImpl.change(itemSeriesDTO);
    }

    @RequestMapping(value="/api/itemSeries/{seriesId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteItemSeries(@PathVariable("seriesId") int seriesId){
        return itemSeriesServiceImpl.delete(seriesId);
    }
}
