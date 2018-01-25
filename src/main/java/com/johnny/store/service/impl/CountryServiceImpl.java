package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CountryDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CountryEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CountryMapper;
import com.johnny.store.service.CountryService;
import com.johnny.store.vo.CountryVO;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CountryVO> modelList= new ArrayList<>();
            int totalCount = countryMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CountryEntity> entityList = countryMapper.searchList(startIndex, pageSize);
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (CountryEntity entity : entityList){
                CountryVO model = new CountryVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
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

    public UnifiedResponse findAll() {
        try {
            List<CountryVO> modelList= new ArrayList<>();
            int totalCount = countryMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CountryEntity> entityList = countryMapper.searchAll();
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (CountryEntity entity : entityList){
                CountryVO model = new CountryVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setCountryID(entity.getCountryID());
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
           CountryVO model = null;
           CountryEntity entity = countryMapper.search(id);
           if (entity != null){
               model = new CountryVO();
               ConvertObjectUtils.convertJavaBean(model,entity);
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
           CountryEntity entity = countryMapper.searchByName(name);
           if (entity != null){
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
            CountryDTO countryDTO = (CountryDTO) dto;
            CountryEntity countryEntity = new CountryEntity();
            ConvertObjectUtils.convertJavaBean(countryEntity, countryDTO);
            countryEntity.setInUser(countryDTO.getLoginUser ());
            countryEntity.setLastEditUser(countryDTO.getLoginUser());
            int affectRow = countryMapper.insert(countryEntity);
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
            CountryDTO countryDTO = (CountryDTO) dto;
            CountryEntity countryEntity = new CountryEntity();
            ConvertObjectUtils.convertJavaBean(countryEntity,countryDTO);
            countryEntity.setCountryID(countryDTO.getCountryID());
            countryEntity.setLastEditUser(countryDTO.getLoginUser());
            int affectRow = countryMapper.update(countryEntity);
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
            int affectRow = countryMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
