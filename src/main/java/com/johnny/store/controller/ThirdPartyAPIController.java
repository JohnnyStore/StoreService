package com.johnny.store.controller;

import com.johnny.store.dto.ThirdPartyAPIDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.ThirdPartyAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdPartyAPIController {
    @Autowired
    private ThirdPartyAPIServiceImpl thirdPartyAPIServiceImpl;

    @RequestMapping(value = "/api/thirdPartyAPI/{pageNumber}/{pageSize}/{thirdPart}/{result}", method = RequestMethod.GET)
    public UnifiedResponse getAllSize(@PathVariable("pageNumber") int pageNumber,
                                      @PathVariable("pageSize") int pageSize,
                                      @PathVariable("thirdPart") String thirdPart,
                                      @PathVariable("result") boolean result){
        return thirdPartyAPIServiceImpl.findList(pageNumber, pageSize, thirdPart, result);
    }

    @RequestMapping(value="/api/thirdPartyAPI", method = RequestMethod.POST)
    public UnifiedResponse addSize(@RequestBody ThirdPartyAPIDTO thirdPartAPIDTO){
        return thirdPartyAPIServiceImpl.add(thirdPartAPIDTO);
    }

}
