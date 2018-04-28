package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemReviewDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ItemReviewEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ItemReviewMapper;
import com.johnny.store.service.ItemReviewService;
import com.johnny.store.vo.ItemReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemReviewServiceImpl implements ItemReviewService {
    
    @Autowired
    private ItemReviewMapper itemReviewMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String itemCode,  String reviewLevel, String reviewStatus) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemReviewVO> modelList = new ArrayList<>();
            int totalCount = itemReviewMapper.searchTotalCount(customerID, itemCode.equals("A") ? null : itemCode, reviewLevel.equals("A") ? null : reviewLevel, reviewStatus.equals("A") ? null : reviewStatus);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemReviewEntity> entityList =  itemReviewMapper.searchList(startIndex, pageSize, customerID, itemCode.equals("A") ? null : itemCode, reviewLevel.equals("A") ? null : reviewLevel, reviewStatus.equals("A") ? null : reviewStatus);
            for (ItemReviewEntity itemReviewEntity : entityList) {
                ItemReviewVO itemReviewVO = new ItemReviewVO();
                ConvertObjectUtils.convertJavaBean(itemReviewVO, itemReviewEntity);
                switch (itemReviewEntity.getReviewStatus()){
                    case "I":
                        itemReviewVO.setPending(true);
                        itemReviewVO.setApproved(false);
                        itemReviewVO.setReject(false);
                        break;
                    case "P":
                        itemReviewVO.setPending(false);
                        itemReviewVO.setApproved(true);
                        itemReviewVO.setReject(false);
                        break;
                    case "N":
                        itemReviewVO.setPending(false);
                        itemReviewVO.setApproved(false);
                        itemReviewVO.setReject(true);
                        break;
                }
                itemReviewVO.setReviewID(itemReviewEntity.getReviewID());
                itemReviewVO.setItemID(itemReviewEntity.getItemID());
                itemReviewVO.setCustomerID(itemReviewEntity.getCustomerID());
                modelList.add(itemReviewVO);
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
    public UnifiedResponse findList(int pageNumber, int pageSize, int itemID, String reviewLevel) {
        try{
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemReviewVO> modelList = new ArrayList<>();

            List<ItemReviewEntity> entityList =  itemReviewMapper.searchList4Item(startIndex, pageSize, itemID, reviewLevel.equals("A") ? null : reviewLevel);
            for (ItemReviewEntity itemReviewEntity : entityList) {
                ItemReviewVO itemReviewVO = new ItemReviewVO();
                ConvertObjectUtils.convertJavaBean(itemReviewVO, itemReviewEntity);
                switch (itemReviewEntity.getReviewStatus()){
                    case "I":
                        itemReviewVO.setPending(true);
                        itemReviewVO.setApproved(false);
                        itemReviewVO.setReject(false);
                        break;
                    case "P":
                        itemReviewVO.setPending(false);
                        itemReviewVO.setApproved(true);
                        itemReviewVO.setReject(false);
                        break;
                    case "N":
                        itemReviewVO.setPending(false);
                        itemReviewVO.setApproved(false);
                        itemReviewVO.setReject(true);
                        break;
                }
                itemReviewVO.setReviewID(itemReviewEntity.getReviewID());
                itemReviewVO.setItemID(itemReviewEntity.getItemID());
                itemReviewVO.setCustomerID(itemReviewEntity.getCustomerID());
                itemReviewVO.setStarNum(itemReviewEntity.getStarNum());
                modelList.add(itemReviewVO);
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
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
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
            ItemReviewDTO customerReviewDTO = (ItemReviewDTO)dto;
            ItemReviewEntity customerReviewEntity = new ItemReviewEntity();
            ConvertObjectUtils.convertJavaBean(customerReviewEntity, customerReviewDTO);
            customerReviewEntity.setInUser(customerReviewDTO.getLoginUser());
            customerReviewEntity.setItemID(customerReviewDTO.getItemID());
            customerReviewEntity.setStarNum(customerReviewDTO.getStarNum());
            customerReviewEntity.setCustomerID(customerReviewDTO.getCustomerID());
            customerReviewEntity.setReviewLevel(customerReviewDTO.getReviewLevel());
            customerReviewEntity.setReviewStatus(customerReviewDTO.getReviewStatus());
            customerReviewEntity.setReviewText(customerReviewDTO.getReviewText());
            customerReviewEntity.setLastEditUser(customerReviewDTO.getLoginUser());
            int affectRow = itemReviewMapper.insert(customerReviewEntity);
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
            ItemReviewDTO customerReviewDTO = (ItemReviewDTO)dto;
            ItemReviewEntity customerReviewEntity = new ItemReviewEntity();
            ConvertObjectUtils.convertJavaBean(customerReviewEntity, customerReviewDTO);
            customerReviewEntity.setReviewID(customerReviewDTO.getReviewID());
            customerReviewEntity.setReviewStatus(customerReviewDTO.getReviewStatus());
            customerReviewEntity.setLastEditUser(customerReviewDTO.getLoginUser());
            int affectRow = itemReviewMapper.update(customerReviewEntity);
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
            int affectRow = itemReviewMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
