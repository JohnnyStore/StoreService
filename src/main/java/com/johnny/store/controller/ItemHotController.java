package com.johnny.store.controller;

import com.johnny.store.dto.ItemHotDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemHotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemHotController {
    @Autowired
    private ItemHotServiceImpl itemHotServiceImpl;

    @RequestMapping(value = "/api/itemHot/{pageNumber}/{pageSize}/{itemID}/{startDate}/{endDate}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("itemID") int itemID,
                                  @PathVariable("startDate") String startDate,
                                  @PathVariable("endDate") String endDate,
                                  @PathVariable("status") String status){
        return itemHotServiceImpl.findList(pageNumber, pageSize, itemID, startDate, endDate, status);
    }

    @RequestMapping(value="/api/itemHot", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ItemHotDTO dto){
        return itemHotServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/itemHot", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ItemHotDTO dto){
        return itemHotServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/itemHot/{itemId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("itemId") int itemId){
        return itemHotServiceImpl.delete(itemId);
    }
}
