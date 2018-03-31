package com.johnny.store.controller;

import com.johnny.store.dto.CollectionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.CollectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollectionController {
    @Autowired
    private CollectionServiceImpl collectionServiceImpl;

    @RequestMapping(value = "/api/collection/{pageNumber}/{pageSize}/{customerID}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("customerID") int customerID,
                                  @PathVariable("status") String status){
        return collectionServiceImpl.findList(pageNumber, pageSize, customerID, status);
    }

    @RequestMapping(value="/api/collection", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody CollectionDTO dto){
        return collectionServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/collection", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody CollectionDTO dto){
        return collectionServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/collection/{collectionId}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("collectionId") int collectionId){
        return collectionServiceImpl.delete(collectionId);
    }
}
