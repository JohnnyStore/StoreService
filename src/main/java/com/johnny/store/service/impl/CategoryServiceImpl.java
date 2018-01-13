package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CategoryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CategoryEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CategoryMapper;
import com.johnny.store.service.CategoryService;
import com.johnny.store.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品一级分类 ServiceImpl
 * @Author liqian
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CategoryVO> modelList = new ArrayList<>();
            int totalCount = categoryMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CategoryEntity> entityList =  categoryMapper.searchList(startIndex, pageSize);
            for (CategoryEntity entity : entityList) {
                CategoryVO model = new CategoryVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCategoryID(entity.getCategoryID());
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            CategoryVO model = null;
            CategoryEntity entity = categoryMapper.search(id);
            if(entity != null){
                model = new CategoryVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCategoryID(entity.getCategoryID());
            }
            return UnifiedResponseManager.buildSuccessResponse(model);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            boolean exist = false;
            CategoryEntity entity = categoryMapper.searchByName(name);
            if(entity != null){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try {
            CategoryDTO categoryDTO = (CategoryDTO)dto;
            CategoryEntity categoryEntity = new CategoryEntity();
            ConvertObjectUtils.convertJavaBean(categoryEntity, categoryDTO);
            categoryEntity.setInUser(categoryDTO.getLoginUser());
            categoryEntity.setLastEditUser(categoryDTO.getLoginUser());
            int affectRow = categoryMapper.insert(categoryEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(Object dto) {
        try {
            CategoryDTO categoryDTO = (CategoryDTO)dto;
            CategoryEntity categoryEntity = new CategoryEntity();
            ConvertObjectUtils.convertJavaBean(categoryEntity, categoryDTO);
            categoryEntity.setCategoryID(categoryDTO.getCategoryID());
            categoryEntity.setLastEditUser(categoryDTO.getLoginUser());
            int affectRow = categoryMapper.update(categoryEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = categoryMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
