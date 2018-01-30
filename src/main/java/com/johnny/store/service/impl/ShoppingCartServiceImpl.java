package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BrandHotDTO;
import com.johnny.store.dto.ShoppingCartDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.BrandHotEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ShoppingCartEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ShoppingCartMapper;
import com.johnny.store.service.ShoppingCartService;
import com.johnny.store.vo.BrandHotVO;
import com.johnny.store.vo.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCartServiceImpl
 *
 * @author liqian
 * @version 1.0.0
 * @since 1.0.0+
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ShoppingCartVO> modelList = new ArrayList<>();
            int totalCount = shoppingCartMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ShoppingCartEntity> entityList =  shoppingCartMapper.searchList(startIndex, pageSize);
            for (ShoppingCartEntity entity : entityList) {
                ShoppingCartVO model = new ShoppingCartVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setShoppingCartID(entity.getShoppingCartID());
                model.setItemID(entity.getItemID());
                model.setCustomerID(entity.getCustomerID());
                model.setShoppingCount(entity.getShoppingCount());
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
        return null;
    }

    public UnifiedResponse find(int customerId,String status) {
        try {
            ShoppingCartVO model = null;
            ShoppingCartEntity entity = shoppingCartMapper.search(customerId,status);
            if(entity != null){
                model = new ShoppingCartVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setShoppingCartID(entity.getShoppingCartID());
                model.setItemID(entity.getItemID());
                model.setCustomerID(entity.getCustomerID());
                model.setShoppingCount(entity.getShoppingCount());
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
            ShoppingCartDTO shoppingCartDTO = (ShoppingCartDTO)dto;
            ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
            ConvertObjectUtils.convertJavaBean(shoppingCartEntity, shoppingCartDTO);
            shoppingCartEntity.setShoppingCartID(shoppingCartDTO.getShoppingCartID());
            shoppingCartEntity.setInUser(shoppingCartDTO.getLoginUser());
            shoppingCartEntity.setItemID(shoppingCartDTO.getItemID());
            shoppingCartEntity.setCustomerID(shoppingCartDTO.getCustomerID());
            shoppingCartEntity.setShoppingCount(shoppingCartDTO.getShoppingCount());
            shoppingCartEntity.setStatus(shoppingCartDTO.getStatus());
            shoppingCartEntity.setLastEditUser(shoppingCartDTO.getLoginUser());
            int affectRow = shoppingCartMapper.insert(shoppingCartEntity);
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
            ShoppingCartDTO shoppingCartDTO = (ShoppingCartDTO)dto;
            ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
            ConvertObjectUtils.convertJavaBean(shoppingCartEntity, shoppingCartDTO);
            shoppingCartEntity.setShoppingCartID(shoppingCartDTO.getShoppingCartID());
            shoppingCartEntity.setItemID(shoppingCartDTO.getItemID());
            shoppingCartEntity.setCustomerID(shoppingCartDTO.getCustomerID());
            shoppingCartEntity.setShoppingCount(shoppingCartDTO.getShoppingCount());
            shoppingCartEntity.setStatus(shoppingCartDTO.getStatus());
            shoppingCartEntity.setLastEditUser(shoppingCartDTO.getLoginUser());
            int affectRow = shoppingCartMapper.update(shoppingCartEntity);
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
            int affectRow = shoppingCartMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
