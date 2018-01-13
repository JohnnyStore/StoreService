package com.johnny.store.controller;

import com.johnny.store.dto.SystemLogDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.SystemLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SystemLogController {
    @Autowired
    private SystemLogServiceImpl systemLogServiceImpl;

    @RequestMapping(value = "/api/systemLog/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getSystemLogList(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return systemLogServiceImpl.findList(pageIndex, pageSize);
    }

    @RequestMapping(value = "/api/systemLog/{logId}", method = RequestMethod.GET)
    public UnifiedResponse getSystemLog(@PathVariable("logId") int logId){
        return systemLogServiceImpl.find(logId);
    }

    @RequestMapping(value="/api/systemLog", method = RequestMethod.POST)
    public UnifiedResponse addSystemLog(@RequestBody SystemLogDTO dto){
        return systemLogServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/systemLog", method = RequestMethod.PUT)
    public UnifiedResponse changeSystemLogStatus(@RequestBody SystemLogDTO dto){
        return systemLogServiceImpl.change(dto);
    }
}
