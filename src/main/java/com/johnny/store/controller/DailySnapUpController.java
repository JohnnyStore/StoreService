package com.johnny.store.controller;

import com.johnny.store.dto.DailySnapUpDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.DailySnapUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DailySnapUpController {
    @Autowired
    private DailySnapUpServiceImpl dailySnapUpServiceImpl;

    @RequestMapping(value = "/api/dailySnapUp/{pageNumber}/{pageSize}/{snapUpDate}/{status}", method = RequestMethod.GET)
    public UnifiedResponse getAll(@PathVariable("pageNumber") int pageNumber,
                                  @PathVariable("pageSize") int pageSize,
                                  @PathVariable("snapUpDate") String snapUpDate,
                                  @PathVariable("status") String status){
        return dailySnapUpServiceImpl.findList(pageNumber, pageSize, snapUpDate, status);
    }

    @RequestMapping(value = "/api/dailySnapUp/{id}", method = RequestMethod.GET)
    public UnifiedResponse get(@PathVariable("id") int id){
        return dailySnapUpServiceImpl.find(id);
    }

    @RequestMapping(value = "/api/dailySnapUp/current", method = RequestMethod.GET)
    public UnifiedResponse get(){
        return dailySnapUpServiceImpl.findCurrentDailySnapUp();
    }

    @RequestMapping(value="/api/dailySnapUp", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody DailySnapUpDTO dto){
        return dailySnapUpServiceImpl.add(dto);
    }

    @RequestMapping(value="/api/dailySnapUp", method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody DailySnapUpDTO dto){
        return dailySnapUpServiceImpl.change(dto);
    }

    @RequestMapping(value="/api/dailySnapUp/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return dailySnapUpServiceImpl.delete(id);
    }
}
