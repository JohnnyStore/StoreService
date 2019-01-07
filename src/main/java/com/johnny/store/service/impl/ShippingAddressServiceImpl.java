package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ShippingAddressDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CityEntity;
import com.johnny.store.entity.CountryEntity;
import com.johnny.store.entity.ProvinceEntity;
import com.johnny.store.entity.ShippingAddressEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CityMapper;
import com.johnny.store.mapper.CountryMapper;
import com.johnny.store.mapper.ProvinceMapper;
import com.johnny.store.mapper.ShippingAddressMapper;
import com.johnny.store.service.ShippingAddressService;
import com.johnny.store.vo.CityVO;
import com.johnny.store.vo.CountryVO;
import com.johnny.store.vo.ProvinceVO;
import com.johnny.store.vo.ShippingAddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

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
            CountryVO countryVO = new CountryVO();
            ProvinceVO provinceVO = new ProvinceVO();
            CityVO cityVO = new CityVO();
            ShippingAddressEntity entity = shippingAddressMapper.search(id);
            CountryEntity countryEntity = countryMapper.search(entity.getShippingCountryID());
            ProvinceEntity provinceEntity = provinceMapper.search(entity.getShippingProvinceID());
            CityEntity cityEntity = cityMapper.search(entity.getShippingCityID());
            if(entity != null){
                model = new ShippingAddressVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                ConvertObjectUtils.convertJavaBean(countryVO, countryEntity);
                ConvertObjectUtils.convertJavaBean(provinceVO, provinceEntity);
                ConvertObjectUtils.convertJavaBean(cityVO, cityEntity);

                model.setShippingID(entity.getShippingID());
                model.setCustomerID(entity.getCustomerID());
                model.setShippingCountryID(entity.getShippingCountryID());
                model.setCountryVO(countryVO);
                model.setShippingProvinceID(entity.getShippingProvinceID());
                model.setProvinceVO(provinceVO);
                model.setShippingCityID(entity.getShippingCityID());
                model.setCityVO(cityVO);
                model.setDefaultAddress(entity.isDefaultAddress());
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
    public UnifiedResponse find4Customer(int customerID) {
        try {
            List<ShippingAddressVO> modelList = new ArrayList<>();
            List<ShippingAddressEntity> entityList = shippingAddressMapper.search4Customer(customerID);
            for (ShippingAddressEntity entity : entityList) {
                CountryVO countryVO = new CountryVO();
                ProvinceVO provinceVO = new ProvinceVO();
                CityVO cityVO = new CityVO();
                ShippingAddressVO model = new ShippingAddressVO();

                CountryEntity countryEntity = countryMapper.search(entity.getShippingCountryID());
                ProvinceEntity provinceEntity = provinceMapper.search(entity.getShippingProvinceID());
                CityEntity cityEntity = cityMapper.search(entity.getShippingCityID());

                if(countryEntity != null){
                    ConvertObjectUtils.convertJavaBean(countryVO, countryEntity);
                }
                if(provinceEntity != null){
                    ConvertObjectUtils.convertJavaBean(provinceVO, provinceEntity);
                }
                if(cityEntity != null){
                    ConvertObjectUtils.convertJavaBean(cityVO, cityEntity);
                }
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setShippingID(entity.getShippingID());
                model.setCustomerID(entity.getCustomerID());
                model.setShippingCountryID(entity.getShippingCountryID());
                model.setShippingProvinceID(entity.getShippingProvinceID());
                model.setDefaultAddress(entity.isDefaultAddress());
                model.setShippingCityID(entity.getShippingCityID());
                model.setCountryVO(countryVO);
                model.setProvinceVO(provinceVO);
                model.setCityVO(cityVO);
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
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
            shippingAddressEntity.setDefaultAddress(shippingAddressDTO.isDefaultAddress());
            shippingAddressEntity.setInUser(shippingAddressDTO.getLoginUser());
            shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());

            if(shippingAddressDTO.isDefaultAddress()){
                shippingAddressMapper.updateDefaultAddressToFalse(shippingAddressEntity);
            }
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
    public UnifiedResponse changeInfo(ShippingAddressDTO shippingAddressDTO) {
        try {
            ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();
            ConvertObjectUtils.convertJavaBean(shippingAddressEntity, shippingAddressDTO);
            shippingAddressEntity.setCustomerID(shippingAddressDTO.getCustomerID());
            shippingAddressEntity.setShippingID(shippingAddressDTO.getShippingID());
            shippingAddressEntity.setShippingCountryID(shippingAddressDTO.getShippingCountryID());
            shippingAddressEntity.setShippingProvinceID(shippingAddressDTO.getShippingProvinceID());
            shippingAddressEntity.setShippingCityID(shippingAddressDTO.getShippingCityID());
            shippingAddressEntity.setDefaultAddress(shippingAddressDTO.isDefaultAddress());
            shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());

            if(shippingAddressDTO.isDefaultAddress()){
                shippingAddressMapper.updateDefaultAddressToFalse(shippingAddressEntity);
            }
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
    public UnifiedResponse change(Object dto) {
        try {
            int affectRow;
            int affectRowCount = 0;
            ShippingAddressDTO shippingAddressDTO = (ShippingAddressDTO)dto;
            ShippingAddressEntity shippingAddressEntity = new ShippingAddressEntity();

            List<ShippingAddressEntity> entityList = shippingAddressMapper.search4Customer(shippingAddressDTO.getCustomerID());

            for (ShippingAddressEntity addressEntity : entityList) {
                if(addressEntity.getShippingID() == shippingAddressDTO.getShippingID()){
                    shippingAddressEntity.setShippingID(addressEntity.getShippingID());
                    shippingAddressEntity.setDefaultAddress(true);
                    shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());
                    affectRow = shippingAddressMapper.updateDefaultAddress(shippingAddressEntity);
                    affectRowCount = affectRowCount + affectRow;
                }else{
                    if(addressEntity.isDefaultAddress()){
                        shippingAddressEntity.setShippingID(addressEntity.getShippingID());
                        shippingAddressEntity.setDefaultAddress(false);
                        shippingAddressEntity.setLastEditUser(shippingAddressDTO.getLoginUser());
                        affectRow = shippingAddressMapper.updateDefaultAddress(shippingAddressEntity);
                        affectRowCount = affectRowCount + affectRow;
                    }
                }
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRowCount);
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
