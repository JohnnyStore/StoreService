package com.johnny.store.controller;

import com.johnny.store.dto.ItemReviewDTO;
import com.johnny.store.dto.ShoppingCartDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 13425 on 2018/1/31.
 */
@RestController
public class ItemReviewController {
    @Autowired
    private ItemReviewServiceImpl customerReviewServiceImpl;

    @RequestMapping(value = "/api/itemReview/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return customerReviewServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/itemReview/condition/{customerId}/{itemId}/{reviewLevel}/{reviewStatus}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("customerId") int customerId,@PathVariable("itemId") int itemId,@PathVariable("reviewLevel") String reviewLevel,@PathVariable("reviewStatus") String reviewStatus){
        return customerReviewServiceImpl.find(customerId, itemId, reviewLevel, reviewStatus);
    }

    @RequestMapping(value="/api/itemReview", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ItemReviewDTO dto){
        return customerReviewServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/itemReview/{customerId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("customerId") int customerId){
        return customerReviewServiceImpl.delete(customerId);
    }
}
