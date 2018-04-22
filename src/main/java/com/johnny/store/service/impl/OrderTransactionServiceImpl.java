package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.OrderTransactionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.*;
import com.johnny.store.manager.BuildViewModel;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemMapper;
import com.johnny.store.mapper.OrderTransactionMapper;
import com.johnny.store.service.OrderTransactionService;
import com.johnny.store.vo.ItemVO;
import com.johnny.store.vo.OrderTransactionVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderTransactionServiceImpl implements OrderTransactionService {
    @Autowired
    private OrderTransactionMapper orderTransactionMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private BuildViewModel buildViewModel;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int orderID) {
        return null;
//        try {
//            List<OrderTransactionVO> modelList = new ArrayList<>();
//            List<OrderTransactionEntity> entityList =  orderTransactionMapper.searchList(orderID);
//            if(entityList.isEmpty()){
//                return UnifiedResponseManager.buildSuccessResponse(null);
//            }
//
//            for (OrderTransactionEntity entity : entityList) {
//                OrderTransactionVO orderTransactionVO = new OrderTransactionVO();
//                ItemEntity itemEntity = itemMapper.search(entity.getItemID());
//                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
//                if(imageEntityList != null && imageEntityList.size() > 0){
//                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
//                }
//                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
//                ConvertObjectUtils.convertJavaBean(orderTransactionVO, entity);
//                orderTransactionVO.setOrderID(entity.getOrderID());
//                orderTransactionVO.setItemID(entity.getItemID());
//                orderTransactionVO.setItemCount(entity.getItemCount());
//                orderTransactionVO.setItemAmount(entity.getItemAmount());
//                orderTransactionVO.setItemVO(itemVO);
//                modelList.add(orderTransactionVO);
//            }
//            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
//        } catch (StoreException ex){
//            LogUtils.processExceptionLog(ex);
//            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
//        } catch (Exception ex) {
//            LogUtils.processExceptionLog(ex);
//            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
//        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            OrderTransactionVO model = null;
            OrderTransactionEntity entity = orderTransactionMapper.search(id);
            if(entity != null){
                model = new OrderTransactionVO();
                ItemEntity itemEntity = itemMapper.search(entity.getItemID());
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }
                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setOrderID(entity.getOrderID());
                model.setItemID(entity.getItemID());
                model.setItemCount(entity.getItemCount());
                model.setItemAmount(entity.getItemAmount());
                model.setCurrencyType(entity.getCurrencyType());
                model.setItemVO(itemVO);
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
            OrderTransactionDTO orderTransactionDTO = (OrderTransactionDTO)dto;
            OrderTransactionEntity orderTransactionEntity = new OrderTransactionEntity();
            ConvertObjectUtils.convertJavaBean(orderTransactionEntity, orderTransactionDTO);
            orderTransactionEntity.setOrderID(orderTransactionDTO.getOrderID());
            orderTransactionEntity.setItemID(orderTransactionDTO.getItemID());
            orderTransactionEntity.setItemCount(orderTransactionDTO.getItemCount());
            orderTransactionEntity.setItemAmount(orderTransactionDTO.getItemAmount());
            orderTransactionEntity.setCurrencyType(orderTransactionDTO.getCurrencyType());
            orderTransactionEntity.setInUser(orderTransactionDTO.getLoginUser());
            orderTransactionEntity.setLastEditUser(orderTransactionDTO.getLoginUser());
            int affectRow = orderTransactionMapper.insert(orderTransactionEntity);
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
       return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = orderTransactionMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
