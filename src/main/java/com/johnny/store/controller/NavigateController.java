package com.johnny.store.controller;

import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.NavigateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigateController {
    @Autowired
    private NavigateServiceImpl navigateServiceImpl;

    @RequestMapping(value = "/api/navigate", method = RequestMethod.GET)
    public UnifiedResponse get(){
        return navigateServiceImpl.find();
    }
}
