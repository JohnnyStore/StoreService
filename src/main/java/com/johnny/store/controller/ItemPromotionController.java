package com.johnny.store.controller;

import com.johnny.store.dto.ItemPromotionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemPromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemPromotionController {
    @Autowired
    private ItemPromotionServiceImpl itemPromotionServiceImpl;

    @RequestMapping(value = "/api/itemPromotion/{pageNumber}/{pageSize}/{itemID}/{startDate}/{endDate}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("itemID") int itemID,
                                  @PathVariable("startDate") String startDate,
                                  @PathVariable("endDate") String endDate,
                                  @PathVariable("status") String status){
        return itemPromotionServiceImpl.findList(pageNumber, pageSize, itemID, startDate, endDate, status);
    }

    @RequestMapping(value = "/api/itemPromotion/{categoryID}/{startDate}/{endDate}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("categoryID") int categoryID,
                                  @PathVariable("startDate") String startDate,
                                  @PathVariable("endDate") String endDate){
        return itemPromotionServiceImpl.findList(categoryID, startDate, endDate);
    }

    @RequestMapping(value = "/api/itemPromotion/current/{categoryID}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("categoryID") int categoryID){
        return itemPromotionServiceImpl.findCurrentList(categoryID);
    }

    @RequestMapping(value="/api/itemPromotion", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ItemPromotionDTO dto){
        return itemPromotionServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/itemPromotion", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ItemPromotionDTO dto){
        return itemPromotionServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/itemPromotion/{itemPromotionId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("itemPromotionId") int itemPromotionId){
        return itemPromotionServiceImpl.delete(itemPromotionId);
    }
}
