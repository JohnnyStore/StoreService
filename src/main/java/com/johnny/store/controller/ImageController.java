package com.johnny.store.controller;

import com.johnny.store.dto.ImageDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @RequestMapping(value = "/api/image/{objectID}/{objectType}", method = RequestMethod.GET)
    public UnifiedResponse findList4Item(@PathVariable("objectID") int objectID,
                                     @PathVariable("objectType") String objectType){
        return imageServiceImpl.findList4Item(objectID, objectType);
    }

    @RequestMapping(value="/api/image/list", method = RequestMethod.POST)
    public UnifiedResponse addList(@RequestBody String dtoList){
        return imageServiceImpl.addList(dtoList);
    }

    @RequestMapping(value="/api/image", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ImageDTO dto){
        return imageServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/image/{objectID}/{objectType}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("objectID") int objectID, @PathVariable("objectType") String objectType){
        return imageServiceImpl.deleteItemImage(objectID, objectType);
    }
}
