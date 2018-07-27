package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemPromotionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ItemPromotionEntity;
import com.johnny.store.entity.ItemPromotionEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemPromotionMapper;
import com.johnny.store.service.ItemPromotionService;
import com.johnny.store.vo.ItemPromotionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPromotionServiceImpl implements ItemPromotionService{

    @Autowired
    private ItemPromotionMapper itemPromotionMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int itemID, String startDate, String endDate, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemPromotionVO> modelList = new ArrayList<>();
            int totalCount = itemPromotionMapper.searchTotalCount(
                    itemID,
                    startDate.equals("N")? null: startDate,
                    endDate.equals("N")? null: endDate,
                    status.equals("N")? null: status);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemPromotionEntity> entityList =  itemPromotionMapper.searchList(
                    startIndex,
                    pageSize,
                    itemID,
                    startDate.equals("N")? null: startDate,
                    endDate.equals("N")? null: endDate,
                    status.equals("N")? null: status);
            for (ItemPromotionEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemPromotionVO model = new ItemPromotionVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setItemPromotionID(entity.getItemPromotionID());
                model.setItemID(entity.getItemID());
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
    public UnifiedResponse findList(int categoryID, String startDate, String endDate) {
        try {
            List<ItemPromotionVO> modelList = new ArrayList<>();
            List<ItemPromotionEntity> entityList =  itemPromotionMapper.searchList4Category(categoryID, startDate, endDate);
            for (ItemPromotionEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemPromotionVO model = new ItemPromotionVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setItemPromotionID(entity.getItemPromotionID());
                model.setItemID(entity.getItemID());
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
            ItemPromotionDTO itemPromotionDTO = (ItemPromotionDTO)dto;
            ItemPromotionEntity itemPromotionEntity = new ItemPromotionEntity();
            ConvertObjectUtils.convertJavaBean(itemPromotionEntity, itemPromotionDTO);
            itemPromotionEntity.setItemPromotionID(itemPromotionDTO.getItemPromotionID());
            itemPromotionEntity.setItemID(itemPromotionDTO.getItemID());
            itemPromotionEntity.setPromotionPrice4RMB(itemPromotionDTO.getPromotionPrice4RMB());
            itemPromotionEntity.setPromotionPrice4USD(itemPromotionDTO.getPromotionPrice4USD());
            itemPromotionEntity.setInUser(itemPromotionDTO.getLoginUser());
            itemPromotionEntity.setLastEditUser(itemPromotionDTO.getLoginUser());
            int affectRow = itemPromotionMapper.insert(itemPromotionEntity);
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
            ItemPromotionDTO itemPromotionDTO = (ItemPromotionDTO)dto;
            ItemPromotionEntity itemPromotionEntity = new ItemPromotionEntity();
            ConvertObjectUtils.convertJavaBean(itemPromotionEntity, itemPromotionDTO);
            itemPromotionEntity.setItemPromotionID(itemPromotionDTO.getItemPromotionID());
            itemPromotionEntity.setItemID(itemPromotionDTO.getItemID());
            itemPromotionEntity.setPromotionPrice4RMB(itemPromotionDTO.getPromotionPrice4RMB());
            itemPromotionEntity.setPromotionPrice4USD(itemPromotionDTO.getPromotionPrice4USD());
            itemPromotionEntity.setLastEditUser(itemPromotionDTO.getLoginUser());
            int affectRow = itemPromotionMapper.update(itemPromotionEntity);
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
            int affectRow = itemPromotionMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
