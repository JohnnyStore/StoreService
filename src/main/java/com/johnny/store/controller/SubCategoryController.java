package com.johnny.store.controller;

import com.johnny.store.dto.SubCategoryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.SubCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品二级分类 Controller
 * @Author liqian
 */
@RestController
public class SubCategoryController {
    @Autowired
    private SubCategoryServiceImpl subCategoryServiceImpl;

    @RequestMapping(value = "/api/subCategory/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllBrand(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return subCategoryServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/subCategory/{subCategoryId}", method = RequestMethod.GET)
    public UnifiedResponse getBrand(@PathVariable("subCategoryId") int subCategoryId){
        return subCategoryServiceImpl.find(subCategoryId);
    }

    @RequestMapping(value = "/api/subCategory/exist/{subCategoryName}", method = RequestMethod.GET)
    public UnifiedResponse checkBrandExist(@PathVariable("subCategoryName") String subCategoryName){
        return subCategoryServiceImpl.existCheck(subCategoryName);
    }

    @RequestMapping(value="/api/subCategory", method = RequestMethod.POST)
    public UnifiedResponse addBrand(@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryServiceImpl.add(subCategoryDTO);
    }

    @RequestMapping(value="/api/subCategory", method = RequestMethod.PUT)
    public UnifiedResponse changeBrand(@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryServiceImpl.change(subCategoryDTO);
    }

    @RequestMapping(value="/api/subCategory/{subCategoryId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteBrand(@PathVariable("subCategoryId") int subCategoryId){
        return subCategoryServiceImpl.delete(subCategoryId);
    }
}
