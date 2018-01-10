package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ProvinceDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ProvinceEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ProvinceMapper;
import com.johnny.store.service.ProvinceService;
import com.johnny.store.vo.ProvinceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ProvinceVO> modelList = new ArrayList<>();
            int totalCount = provinceMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ProvinceEntity> entityList =  provinceMapper.searchList(startIndex, pageSize);
            if(entityList.isEmpty()){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            for (ProvinceEntity entity : entityList) {
                ProvinceVO model = new ProvinceVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setProvinceID(entity.getProvinceID());
                model.setCountryID(entity.getCountryID());
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount,modelList);
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
            ProvinceVO model = null;
            ProvinceEntity entity = provinceMapper.search(id);
            if(entity != null){
                model = new ProvinceVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setProvinceID(entity.getProvinceID());
                model.setCountryID(entity.getCountryID());
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

    public UnifiedResponse findByCountry(int countryID) {
        try {
            List<ProvinceVO> modelList = new ArrayList<>();
            List<ProvinceEntity> entityList = provinceMapper.searchByCountry(countryID);
            if(entityList.isEmpty()){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            for (ProvinceEntity entity : entityList) {
                ProvinceVO model = new ProvinceVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setProvinceID(entity.getProvinceID());
                model.setCountryID(entity.getCountryID());
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(entityList.size(), modelList);
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
            ProvinceEntity entity = provinceMapper.searchByName(name);
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
            ProvinceDTO provinceDTO = (ProvinceDTO)dto;
            ProvinceEntity provinceEntity = new ProvinceEntity();
            ConvertObjectUtils.convertJavaBean(provinceEntity, provinceDTO);
            provinceEntity.setCountryID(provinceDTO.getCountryID());
            provinceEntity.setInUser(provinceDTO.getLoginUser());
            provinceEntity.setLastEditUser(provinceDTO.getLoginUser());
            int affectRow = provinceMapper.insert(provinceEntity);
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
            ProvinceDTO provinceDTO = (ProvinceDTO)dto;
            ProvinceEntity provinceEntity = new ProvinceEntity();
            ConvertObjectUtils.convertJavaBean(provinceEntity, provinceDTO);
            provinceEntity.setProvinceID(provinceDTO.getProvinceID());
            provinceEntity.setCountryID(provinceDTO.getCountryID());
            provinceEntity.setLastEditUser(provinceDTO.getLoginUser());
            int affectRow = provinceMapper.update(provinceEntity);
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
            int affectRow = provinceMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
