package com.johnny.store.controller;

import com.johnny.store.dto.CategoryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品一级分类 Controller
 * @Author liqian
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @RequestMapping(value = "/api/category/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse getAllCategory(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return categoryServiceImpl.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/api/category/{categoryId}", method = RequestMethod.GET)
    public UnifiedResponse getCategory(@PathVariable("categoryId") int categoryId){
        return categoryServiceImpl.find(categoryId);
    }

    @RequestMapping(value = "/api/category/exist/{categoryName}", method = RequestMethod.GET)
    public UnifiedResponse checkCategoryExist(@PathVariable("categoryName") String categoryName){
        return categoryServiceImpl.existCheck(categoryName);
    }

    @RequestMapping(value="/api/category", method = RequestMethod.POST)
    public UnifiedResponse addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryServiceImpl.add(categoryDTO);
    }

    @RequestMapping(value="/api/category", method = RequestMethod.PUT)
    public UnifiedResponse changeCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryServiceImpl.change(categoryDTO);
    }

    @RequestMapping(value="/api/category/{categoryId}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteCategory(@PathVariable("categoryId") int categoryId){
        return categoryServiceImpl.delete(categoryId);
    }
}
