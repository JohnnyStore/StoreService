package com.johnny.store.controller;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @RequestMapping(value = "/api/item/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return itemServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/item/{itemId}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("itemId") int itemId){
        return itemServiceImpl.find(itemId);
    }

    @RequestMapping(value = "/api/item/exist/{itemCode}", method = RequestMethod.GET)
    public UnifiedResponse checkName(@PathVariable("itemCode") String itemCode){
        return itemServiceImpl.existCheck(itemCode);
    }

    @RequestMapping(value = "/api/item/exist/{brandID}/{categoryID}/{subCategoryID}/{seriesID}/{itemName}", method = RequestMethod.GET)
    public UnifiedResponse checkName(@PathVariable("brandID") int brandID,
                                     @PathVariable("categoryID") int categoryID,
                                     @PathVariable("subCategoryID") int subCategoryID,
                                     @PathVariable("seriesID") int seriesID,
                                     @PathVariable("itemName") String itemName){
        return itemServiceImpl.existCheck(brandID, categoryID, subCategoryID, seriesID, itemName);
    }

    @RequestMapping(value="/api/item", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ItemDTO dto){
        return itemServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/item", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ItemDTO dto){
        return itemServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/item/{itemId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("itemId") int itemId){
        return itemServiceImpl.delete(itemId);
    }
}
