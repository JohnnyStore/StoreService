package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.DateUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ShoppingCartDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.DailySnapUpEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.entity.ShoppingCartEntity;
import com.johnny.store.manager.BuildViewModel;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.DailySnapUpMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemMapper;
import com.johnny.store.mapper.ShoppingCartMapper;
import com.johnny.store.service.ShoppingCartService;
import com.johnny.store.vo.ItemVO;
import com.johnny.store.vo.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCartServiceImpl
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

    @Autowired
    private DailySnapUpMapper dailySnapUpMapper;

    @Autowired
    private BuildViewModel buildViewModel;


    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
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
                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
                double totalPrice4RMB = shoppingCartentity.getShoppingCount() * itemEntity.getUnitPrice4RMB();
                double totalPrice4USD = shoppingCartentity.getShoppingCount() * itemEntity.getUnitPrice4USD();
                ConvertObjectUtils.convertJavaBean(shoppingCartVO, shoppingCartentity);
                shoppingCartVO.setShoppingCartID(shoppingCartentity.getShoppingCartID());
                shoppingCartVO.setItemID(shoppingCartentity.getItemID());
                shoppingCartVO.setCustomerID(shoppingCartentity.getCustomerID());
                shoppingCartVO.setShoppingCount(shoppingCartentity.getShoppingCount());
                shoppingCartVO.setItemVO(itemVO);
                shoppingCartVO.setTotalPrice4RMB(Double.parseDouble(decimalFormat.format(totalPrice4RMB)));
                shoppingCartVO.setTotalPrice4USD(Double.parseDouble(decimalFormat.format(totalPrice4USD)));
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
    public UnifiedResponse findList4Customer(int customerID) {
        try{
            List<ShoppingCartVO> modelList = new ArrayList<>();
            List<ShoppingCartEntity> entityList =  shoppingCartMapper.searchList4Customer(customerID);
            if(entityList == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            for (ShoppingCartEntity shoppingCartentity : entityList) {
                ItemEntity itemEntity = itemMapper.search(shoppingCartentity.getItemID());
                List<ImageEntity> imageEntityList = imageMapper.searchList(shoppingCartentity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }
                ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
                ConvertObjectUtils.convertJavaBean(shoppingCartVO, shoppingCartentity);

                //当前商品在当天是否有抢购，如果有，则使用抢购价格
                String today = DateUtils.getCurrentDateTime().substring(0, 10);
                List<DailySnapUpEntity> dailySnapUpEntityList = dailySnapUpMapper.searchByItemID(shoppingCartentity.getItemID(), today);
//                if(dailySnapUpEntityList != null && dailySnapUpEntityList.size() > 0){
//                    itemVO.setSalesPrice4RMB(dailySnapUpEntityList.get(0).getSnapUpPrice4RMB());
//                    itemVO.setSalesPrice4USD(dailySnapUpEntityList.get(0).getSnapUpPrice4USD());
//                }else if(itemEntity.getPromotionPrice4RMB() > 0){
//                    itemVO.setSalesPrice4RMB(itemEntity.getPromotionPrice4RMB());
//                    itemVO.setSalesPrice4USD(itemEntity.getPromotionPrice4USD());
//                }else{
//                    itemVO.setSalesPrice4RMB(itemEntity.getUnitPrice4RMB());
//                    itemVO.setSalesPrice4USD(itemEntity.getUnitPrice4USD());
//                }

                shoppingCartVO.setShoppingCartID(shoppingCartentity.getShoppingCartID());
                shoppingCartVO.setItemID(shoppingCartentity.getItemID());
                shoppingCartVO.setCustomerID(shoppingCartentity.getCustomerID());
                shoppingCartVO.setShoppingCount(shoppingCartentity.getShoppingCount());
                shoppingCartVO.setItemVO(itemVO);
                shoppingCartVO.setTotalPrice4RMB(shoppingCartentity.getShoppingCount() * itemVO.getSalesPrice4RMB());
                shoppingCartVO.setTotalPrice4USD(shoppingCartentity.getShoppingCount() * itemVO.getSalesPrice4USD());

                modelList.add(shoppingCartVO);
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
            shoppingCartEntity.setStatus("I");
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
    public UnifiedResponse changeStatus(Object dto) {
        try {
            ShoppingCartDTO shoppingCartDTO = (ShoppingCartDTO)dto;
            ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
            ConvertObjectUtils.convertJavaBean(shoppingCartEntity, shoppingCartDTO);
            shoppingCartEntity.setLastEditUser(shoppingCartDTO.getLoginUser());
            int affectRow = shoppingCartMapper.updateStatus(shoppingCartEntity);
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
