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
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.entity.ShoppingCartEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemMapper;
import com.johnny.store.mapper.ShoppingCartMapper;
import com.johnny.store.service.ShoppingCartService;
import com.johnny.store.vo.BrandHotVO;
import com.johnny.store.vo.ItemVO;
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

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ShoppingCartVO> modelList = new ArrayList<>();
            int totalCount = shoppingCartMapper.searchTotalCount(customerID, status.equals("A") ? null : status);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ShoppingCartEntity> entityList =  shoppingCartMapper.searchList(startIndex, pageSize, customerID, status.equals("A") ? null : status);
            for (ShoppingCartEntity shoppingCartentity : entityList) {
                ItemEntity itemEntity = itemMapper.search(shoppingCartentity.getItemID());
                List<ImageEntity> imageEntityList = imageMapper.searchList(shoppingCartentity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                ItemVO itemVO = new ItemVO();
                ConvertObjectUtils.convertJavaBean(itemVO, itemEntity);
                ConvertObjectUtils.convertJavaBean(shoppingCartVO, shoppingCartentity);

                itemVO.setItemID(itemEntity.getItemID());
                itemVO.setBrandID(itemEntity.getBrandID());
                itemVO.setCategoryID(itemEntity.getCategoryID());
                itemVO.setSubCategoryID(itemEntity.getSubCategoryID());
                itemVO.setItemGroupID(itemEntity.getItemGroupID());
                itemVO.setSeriesID(itemEntity.getSeriesID());
                itemVO.setUnitPrice4RMB(itemEntity.getUnitPrice4RMB());
                itemVO.setPromotionPrice4RMB(itemEntity.getPromotionPrice4RMB());
                itemVO.setUnitPrice4USD(itemEntity.getUnitPrice4USD());
                itemVO.setPromotionPrice4USD(itemEntity.getPromotionPrice4USD());
                itemVO.setRate(itemEntity.getRate());
                itemVO.setColorID(itemEntity.getColorID());
                itemVO.setSizeID(itemEntity.getSizeID());
                itemVO.setMadeInID(itemEntity.getMadeInID());

                shoppingCartVO.setShoppingCartID(shoppingCartentity.getShoppingCartID());
                shoppingCartVO.setItemID(shoppingCartentity.getItemID());
                shoppingCartVO.setCustomerID(shoppingCartentity.getCustomerID());
                shoppingCartVO.setShoppingCount(shoppingCartentity.getShoppingCount());
                shoppingCartVO.setItemVO(itemVO);
                shoppingCartVO.setTotalPrice4RMB(shoppingCartentity.getShoppingCount() * itemEntity.getUnitPrice4RMB());
                shoppingCartVO.setTotalPrice4USD(shoppingCartentity.getShoppingCount() * itemEntity.getUnitPrice4USD());
                modelList.add(shoppingCartVO);
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
