package com.johnny.store.service.impl;

import com.johnny.store.common.*;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemHotDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ItemHotEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemHotMapper;
import com.johnny.store.service.ItemHotService;
import com.johnny.store.vo.ItemHotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemHotServiceImpl implements ItemHotService{

    @Autowired
    private ItemHotMapper itemHotMapper;

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
            List<ItemHotVO> modelList = new ArrayList<>();
            int totalCount = itemHotMapper.searchTotalCount(
                    itemID,
                    startDate.equals("N")? null: startDate,
                    endDate.equals("N")? null: endDate,
                    status.equals("N")? null: status);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemHotEntity> entityList =  itemHotMapper.searchList(
                    startIndex,
                    pageSize,
                    itemID,
                    startDate.equals("N")? null: startDate,
                    endDate.equals("N")? null: endDate,
                    status.equals("N")? null: status);
            for (ItemHotEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemHotVO model = new ItemHotVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setItemHotID(entity.getItemHotID());
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
    public UnifiedResponse findCurrentList(String source) {
        try {
            List<ItemHotVO> modelList = new ArrayList<>();
            String currentDate = DateUtils.getCurrentDateTime();
            int maxCount = 0;
            int totalCount = 0;

            if ("M".equals(source)){
                maxCount = 99999;
            }else{
                maxCount = 8;
            }
            List<ItemHotEntity> entityList =  itemHotMapper.searchCurrentList(currentDate);
            if(entityList == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }

            for (ItemHotEntity entity : entityList) {
                totalCount++;
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemHotVO model = new ItemHotVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setItemHotID(entity.getItemHotID());
                model.setItemID(entity.getItemID());
                modelList.add(model);
                if(totalCount >= maxCount){
                    break;
                }
            }
            return UnifiedResponseManager.buildSuccessResponse(entityList.size(), modelList);
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
            ItemHotVO model = null;
            ItemHotEntity entity = itemHotMapper.search(id);
            if(entity != null){
                model = new ItemHotVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setItemHotID(entity.getItemHotID());
                model.setItemID(entity.getItemID());
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
            ItemHotDTO itemHotDTO = (ItemHotDTO)dto;
            ItemHotEntity itemHotEntity = new ItemHotEntity();
            ConvertObjectUtils.convertJavaBean(itemHotEntity, itemHotDTO);
            itemHotEntity.setItemHotID(itemHotDTO.getItemHotID());
            itemHotEntity.setItemID(itemHotDTO.getItemID());
            itemHotEntity.setInUser(itemHotDTO.getLoginUser());
            itemHotEntity.setLastEditUser(itemHotDTO.getLoginUser());
            int affectRow = itemHotMapper.insert(itemHotEntity);
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
            ItemHotDTO itemHotDTO = (ItemHotDTO)dto;
            ItemHotEntity itemHotEntity = new ItemHotEntity();
            ConvertObjectUtils.convertJavaBean(itemHotEntity, itemHotDTO);
            itemHotEntity.setItemHotID(itemHotDTO.getItemHotID());
            itemHotEntity.setItemID(itemHotDTO.getItemID());
            itemHotEntity.setLastEditUser(itemHotDTO.getLoginUser());
            int affectRow = itemHotMapper.update(itemHotEntity);
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
            int affectRow = itemHotMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
