package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.MaterialDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.MaterialEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.MaterialMapper;
import com.johnny.store.service.MaterialSevice;
import com.johnny.store.vo.MaterialVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialSevice {
    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageMaterial) {
        try {
            int startIndex = (pageNumber - 1) * pageMaterial;
            List<MaterialVO> modelList = new ArrayList<>();
            int totalCount = materialMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<MaterialEntity> entityList =  materialMapper.searchList(startIndex, pageMaterial);
            for (MaterialEntity entity : entityList) {
                MaterialVO model = new MaterialVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setMaterialID(entity.getMaterialID());
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
            MaterialVO model = null;
            MaterialEntity entity = materialMapper.search(id);
            if(entity != null){
                model = new MaterialVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setMaterialID(entity.getMaterialID());
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
            MaterialEntity entity = materialMapper.searchByName(name);
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
            MaterialDTO materialDTO = (MaterialDTO)dto;
            MaterialEntity materialEntity = new MaterialEntity();
            ConvertObjectUtils.convertJavaBean(materialEntity, materialDTO);
            materialEntity.setInUser(materialDTO.getLoginUser());
            materialEntity.setLastEditUser(materialDTO.getLoginUser());
            int affectRow = materialMapper.insert(materialEntity);
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
            MaterialDTO materialDTO = (MaterialDTO)dto;
            MaterialEntity materialEntity = new MaterialEntity();
            ConvertObjectUtils.convertJavaBean(materialEntity, materialDTO);
            materialEntity.setMaterialID(materialDTO.getMaterialID());
            materialEntity.setLastEditUser(materialDTO.getLoginUser());
            int affectRow = materialMapper.update(materialEntity);
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
            int affectRow = materialMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
