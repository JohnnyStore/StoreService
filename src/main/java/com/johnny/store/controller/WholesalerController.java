package com.johnny.store.controller;

import com.johnny.store.dto.WholesalerDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.WholesalerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WholesalerController {
    @Autowired
    private WholesalerServiceImpl wholesalerServiceImpl;

    @RequestMapping(value = "api/wholesaler/{pageNumber}/{pageSize}/{cellphone}/{email}/{status}",method = RequestMethod.GET)
    public UnifiedResponse getWholesalerList(@PathVariable("pageNumber") int pageNumber,
                                             @PathVariable("pageSize") int pageSize,
                                             @PathVariable("cellphone") String cellphone,
                                             @PathVariable("email") String email,
                                             @PathVariable("status") String status){
        return wholesalerServiceImpl.findList(pageNumber, pageSize, cellphone, email, status);
    }

    @RequestMapping(value = "api/wholesaler/{wholesalerID}",method = RequestMethod.GET)
    public UnifiedResponse getWholesaler(@PathVariable("wholesalerID") int wholesalerID){
        return wholesalerServiceImpl.find(wholesalerID);
    }

    @RequestMapping(value="api/wholesaler", method = RequestMethod.POST)
    public UnifiedResponse addBrand(@RequestBody WholesalerDTO wholesalerDTO){
        return wholesalerServiceImpl.add(wholesalerDTO);
    }

    @RequestMapping(value = "api/wholesaler/changeStatus",method = RequestMethod.PUT)
    public UnifiedResponse changeWholesalerStatus(@RequestBody WholesalerDTO wholesalerDTO){
        return wholesalerServiceImpl.changeStatus(wholesalerDTO);
    }

    @RequestMapping(value = "api/wholesaler/changePassword",method = RequestMethod.PUT)
    public UnifiedResponse changeWholesalerPassword(@RequestBody WholesalerDTO wholesalerDTO){
        return wholesalerServiceImpl.changePassword(wholesalerDTO);
    }

    @RequestMapping(value = "api/wholesaler",method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody WholesalerDTO wholesalerDTO){
        return wholesalerServiceImpl.change(wholesalerDTO);
    }

    @RequestMapping(value="api/wholesaler/{wholesalerId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteBrand(@PathVariable("wholesalerId") int wholesalerId){
        return wholesalerServiceImpl.delete(wholesalerId);
    }
}


