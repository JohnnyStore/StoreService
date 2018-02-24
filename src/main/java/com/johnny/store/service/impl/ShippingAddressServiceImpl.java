package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ShippingAddressDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ShippingAddressEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ShippingAddressMapper;
import com.johnny.store.service.ShippingAddressService;
import com.johnny.store.vo.ShippingAddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ShippingAddressVO> modelList = new ArrayList<>();
            int totalCount = shippingAddressMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ShippingAddressEntity> entityList =  shippingAddressMapper.searchList(startIndex, pageSize);
            for (ShippingAddressEntity entity : entityList) {
                ShippingAddressVO model = new ShippingAddressVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setShippingID(entity.getShippingID());
                model.setCustomerID(entity.getCustomerID());
                model.setShippingCountryID(entity.getShippingCountryID());
                model.setShippingProvinceID(entity.getShippingProvinceID());
                model.setShippingCityID(entity.getShippingCityID());
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
            ShippingAddressVO model = null;
            ShippingAddressEntity entity = shippingAddressMapper.search(id);
            if(entity != null){
                model = new ShippingAddressVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setShippingID(entity.getShippingID());
                model.setCustomerID(entity.getCustomerID());
                model.setShippingCountryID(entity.getShippingCountryID());
                model.setShippingProvinceID(entity.getShippingProvinceID());
                model.setShippingCityID(entity.getShippingCityID());
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
        return null;
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try {
            ShippingAddressDTO shippingAddressDTO = (ShippingAddressDTO)dto;
            ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();
            ConvertObjectUtils.convertJavaBean(shippingAddressEntity, shippingAddressDTO);
            shippingAddressEntity.setShippingID(shippingAddressDTO.getShippingID());
            shippingAddressEntity.setCustomerID(shippingAddressDTO.getCustomerID());
            shippingAddressEntity.setShippingCountryID(shippingAddressDTO.getShippingCountryID());
            shippingAddressEntity.setShippingProvinceID(shippingAddressDTO.getShippingProvinceID());
            shippingAddressEntity.setShippingCityID(shippingAddressDTO.getShippingCityID());
            shippingAddressEntity.setInUser(shippingAddressDTO.getLoginUser());
            shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());
            int affectRow = shippingAddressMapper.insert(shippingAddressEntity);
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
            ShippingAddressDTO shippingAddressDTO = (ShippingAddressDTO)dto;
            ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();
            ConvertObjectUtils.convertJavaBean(shippingAddressEntity, shippingAddressDTO);
            shippingAddressEntity.setShippingID(shippingAddressDTO.getShippingID());
            shippingAddressEntity.setCustomerID(shippingAddressDTO.getCustomerID());
            shippingAddressEntity.setShippingCountryID(shippingAddressDTO.getShippingCountryID());
            shippingAddressEntity.setShippingProvinceID(shippingAddressDTO.getShippingProvinceID());
            shippingAddressEntity.setShippingCityID(shippingAddressDTO.getShippingCityID());
            shippingAddressEntity.setInUser(shippingAddressDTO.getLoginUser());
            shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());
            int affectRow = shippingAddressMapper.update(shippingAddressEntity);
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
            int affectRow = shippingAddressMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
