package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BrandDTO;
import com.johnny.store.dto.SubCategoryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.BrandEntity;
import com.johnny.store.entity.SubCategoryEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.SubCategoryMapper;
import com.johnny.store.service.SubCategoryService;
import com.johnny.store.vo.SubCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品二级分类 ServiceImpl
 * @Author liqian
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<SubCategoryVO> modelList = new ArrayList<>();
            int totalCount = subCategoryMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<SubCategoryEntity> entityList =  subCategoryMapper.searchList(startIndex, pageSize);
            for (SubCategoryEntity entity : entityList) {
                SubCategoryVO model = new SubCategoryVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSubCategoryID(entity.getSubCategoryID());
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
            SubCategoryVO model = null;
            SubCategoryEntity entity = subCategoryMapper.search(id);
            if(entity != null){
                model = new SubCategoryVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSubCategoryID(entity.getSubCategoryID());
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
            SubCategoryEntity entity = subCategoryMapper.searchByName(name);
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
            SubCategoryDTO subCategoryDTO = (SubCategoryDTO)dto;
            SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
            ConvertObjectUtils.convertJavaBean(subCategoryEntity, subCategoryDTO);
            subCategoryEntity.setInUser(subCategoryDTO.getLoginUser());
            subCategoryEntity.setLastEditUser(subCategoryDTO.getLoginUser());
            int affectRow = subCategoryMapper.insert(subCategoryEntity);
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
            SubCategoryDTO subCategoryDTO = (SubCategoryDTO)dto;
            SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
            ConvertObjectUtils.convertJavaBean(subCategoryEntity, subCategoryDTO);
            subCategoryEntity.setSubCategoryID(subCategoryDTO.getSubCategoryID());
            subCategoryEntity.setLastEditUser(subCategoryDTO.getLoginUser());
            int affectRow = subCategoryMapper.update(subCategoryEntity);
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
            int affectRow = subCategoryMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
