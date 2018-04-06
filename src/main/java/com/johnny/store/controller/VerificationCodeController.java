package com.johnny.store.controller;

import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.dto.VerificationCodeDTO;
import com.johnny.store.service.impl.VerificationCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeServiceImpl verificationCodeImpl;

    @RequestMapping(value = "/api/verificationCode/{cellphone}/{verificationCode}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("cellphone") String cellphone, @PathVariable("verificationCode") String verificationCode){
        return verificationCodeImpl.find(cellphone, verificationCode);
    }

    @RequestMapping(value="/api/verificationCode", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody VerificationCodeDTO dto){
        return verificationCodeImpl.add(dto);
    }
}
