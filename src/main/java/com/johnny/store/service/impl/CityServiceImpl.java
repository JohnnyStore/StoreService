package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CityDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CityEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CityMapper;
import com.johnny.store.service.BaseService;
import com.johnny.store.service.CityService;
import com.johnny.store.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CityVO> modelList = new ArrayList<>();
            int totalCount = cityMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CityEntity> entityList =  cityMapper.searchList(startIndex, pageSize);
            if(entityList.isEmpty()){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            for (CityEntity entity : entityList) {
                CityVO model = new CityVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCityID(entity.getCityID());
                model.setCountryID(entity.getCountryID());
                model.setProvinceID(entity.getProvinceID());
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
            CityVO model = null;
            CityEntity entity = cityMapper.search(id);
            if(entity != null){
                model = new CityVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCityID(entity.getCityID());
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

    @Override
    public UnifiedResponse existCheck(String name) {
        try {
            boolean exist = false;
            CityEntity entity = cityMapper.searchByName(name);
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
            CityDTO cityDTO = (CityDTO)dto;
            CityEntity cityEntity = new CityEntity();
            ConvertObjectUtils.convertJavaBean(cityEntity, cityDTO);
            cityEntity.setProvinceID(cityDTO.getProvinceID());
            cityEntity.setCountryID(cityDTO.getCountryID());
            cityEntity.setInUser(cityDTO.getLoginUser());
            cityEntity.setLastEditUser(cityDTO.getLoginUser());
            int affectRow = cityMapper.insert(cityEntity);
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
            CityDTO cityDTO = (CityDTO)dto;
            CityEntity cityEntity = new CityEntity();
            ConvertObjectUtils.convertJavaBean(cityEntity, cityDTO);
            cityEntity.setCityID(cityDTO.getCityID());
            cityEntity.setProvinceID(cityDTO.getProvinceID());
            cityEntity.setCountryID(cityDTO.getCountryID());
            cityEntity.setLastEditUser(cityDTO.getLoginUser());
            int affectRow = cityMapper.update(cityEntity);
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
            int affectRow = cityMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
