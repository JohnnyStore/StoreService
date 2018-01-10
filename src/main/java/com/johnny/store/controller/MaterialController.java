package com.johnny.store.controller;

import com.johnny.store.dto.MaterialDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品材质
 */
@RestController
public class MaterialController {
    @Autowired
    private MaterialServiceImpl materialServiceImpl;

    @RequestMapping(value = "/api/material/{pageNumber}/{pageMaterial}", method = RequestMethod.GET)
    public UnifiedResponse getAllMaterial(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageMaterial") int pageMaterial){
        return materialServiceImpl.findList(pageNumber, pageMaterial);
    }

    @RequestMapping(value = "/api/material/{materialId}", method = RequestMethod.GET)
    public UnifiedResponse getMaterial(@PathVariable("materialId") int materialId){
        return materialServiceImpl.find(materialId);
    }

    @RequestMapping(value = "/api/material/exist/{materialName}", method = RequestMethod.GET)
    public UnifiedResponse checkMaterialExist(@PathVariable("materialName") String materialName){
        return materialServiceImpl.existCheck(materialName);
    }

    /**
     * 添加新材质
     * @param materialDTO
     * @return
     */
    @RequestMapping(value="/api/material", method = RequestMethod.POST)
    public UnifiedResponse addMaterial(@RequestBody MaterialDTO materialDTO){
        return materialServiceImpl.add(materialDTO);
    }

    @RequestMapping(value="/api/material", method = RequestMethod.PUT)
    public UnifiedResponse changeMaterial(@RequestBody MaterialDTO materialDTO){
        return materialServiceImpl.change(materialDTO);
    }

    @RequestMapping(value="/api/material/{materialId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteMaterial(@PathVariable("materialId") int materialId){
        return materialServiceImpl.delete(materialId);
    }
}
