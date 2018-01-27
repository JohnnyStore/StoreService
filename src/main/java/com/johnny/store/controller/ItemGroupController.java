package com.johnny.store.controller;

import com.johnny.store.dto.ItemGroupDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ItemGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemGroupController {
    @Autowired
    private ItemGroupServiceImpl itemGroupServiceImpl;

    @RequestMapping(value = "api/itemGroup/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public UnifiedResponse getItemGroupList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return itemGroupServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "api/itemGroup/{brandID}/{categoryID}/{subCategoryID}",method = RequestMethod.GET)
    public UnifiedResponse getItemGroupList(@PathVariable("brandID") int brandID,
                                            @PathVariable("categoryID") int categoryID,
                                            @PathVariable("subCategoryID") int subCategoryID){
        return itemGroupServiceImpl.findList(brandID, categoryID, subCategoryID);
    }

    @RequestMapping(value = "api/itemGroup",method = RequestMethod.GET)
    public UnifiedResponse getAllItemGroup(){
        return itemGroupServiceImpl.findAll();
    }

    @RequestMapping(value = "api/itemGroup/{itemGroupID}",method = RequestMethod.GET)
    public UnifiedResponse getItemGroup(@PathVariable("itemGroupID") int itemGroupID){
        return itemGroupServiceImpl.find(itemGroupID);
    }

    @RequestMapping(value = "api/itemGroup/exist/{itemGroupName}",method = RequestMethod.GET)
    public UnifiedResponse checkItemGroupExist(@PathVariable("itemGroupName") String itemGroupName){
        return itemGroupServiceImpl.existCheck(itemGroupName);
    }

    @RequestMapping(value = "api/itemGroup",method = RequestMethod.POST)
    public UnifiedResponse addItemGroup(@RequestBody ItemGroupDTO dto){
        return itemGroupServiceImpl.add(dto);
    }

    @RequestMapping(value = "api/itemGroup",method = RequestMethod.PUT)
    public UnifiedResponse changeItemGroup(@RequestBody ItemGroupDTO dto){
        return itemGroupServiceImpl.change(dto);
    }

    @RequestMapping(value = "api/itemGroup/{itemGroupID}",method = RequestMethod.DELETE)
    public UnifiedResponse deleteItemGroup(@PathVariable int itemGroupID){
        return itemGroupServiceImpl.delete(itemGroupID);
    }

}
