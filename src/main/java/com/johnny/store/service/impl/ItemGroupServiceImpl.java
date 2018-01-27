package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemGroupDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ItemGroupEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ItemGroupMapper;
import com.johnny.store.service.ItemGroupService;
import com.johnny.store.vo.ItemGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemGroupServiceImpl implements ItemGroupService {
    @Autowired
    private ItemGroupMapper itemGroupMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemGroupVO> modelList= new ArrayList<>();
            int totalCount = itemGroupMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemGroupEntity> entityList = itemGroupMapper.searchList(startIndex, pageSize);
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (ItemGroupEntity entity : entityList){
                modelList.add(buildItemGroupVO(entity));
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

    public UnifiedResponse findList(int brandID, int categoryID, int subCategoryID) {
        try {
            List<ItemGroupVO> modelList= new ArrayList<>();
            List<ItemGroupEntity> entityList = itemGroupMapper.searchItemGroupWithCondition(brandID, categoryID, subCategoryID);
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            for (ItemGroupEntity entity : entityList){
                modelList.add(buildItemGroupVO(entity));
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

    public UnifiedResponse findAll() {
        try {
            List<ItemGroupVO> modelList= new ArrayList<>();
            int totalCount = itemGroupMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemGroupEntity> entityList = itemGroupMapper.searchAll();
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (ItemGroupEntity entity : entityList){
                modelList.add(buildItemGroupVO(entity));
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
            ItemGroupVO model = null;
            ItemGroupEntity entity = itemGroupMapper.search(id);
            if (entity != null){
                model = buildItemGroupVO(entity);
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

    private ItemGroupVO buildItemGroupVO(ItemGroupEntity entity) throws StoreException {
        ItemGroupVO model = new ItemGroupVO();
        if(entity != null){
            ConvertObjectUtils.convertJavaBean(model,entity);
            model.setItemGroupID(entity.getItemGroupID());
            model.setBrandID(entity.getBrandID());
            model.setCategoryID(entity.getCategoryID());
            model.setSubCategoryID(entity.getSubCategoryID());
        }
        return model;
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try {
            ItemGroupDTO itemGroupDTO = (ItemGroupDTO) dto;
            ItemGroupEntity itemGroupEntity = new ItemGroupEntity();
            ConvertObjectUtils.convertJavaBean(itemGroupEntity, itemGroupDTO);
            itemGroupEntity.setItemGroupID(itemGroupDTO.getItemGroupID());
            itemGroupEntity.setBrandID(itemGroupDTO.getBrandID());
            itemGroupEntity.setCategoryID(itemGroupDTO.getCategoryID());
            itemGroupEntity.setSubCategoryID(itemGroupDTO.getSubCategoryID());
            itemGroupEntity.setInUser(itemGroupDTO.getLoginUser ());
            itemGroupEntity.setLastEditUser(itemGroupDTO.getLoginUser());
            int affectRow = itemGroupMapper.insert(itemGroupEntity);
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
            ItemGroupDTO itemGroupDTO = (ItemGroupDTO) dto;
            ItemGroupEntity itemGroupEntity = new ItemGroupEntity();
            ConvertObjectUtils.convertJavaBean(itemGroupEntity, itemGroupDTO);
            itemGroupEntity.setItemGroupID(itemGroupDTO.getItemGroupID());
            itemGroupEntity.setBrandID(itemGroupDTO.getBrandID());
            itemGroupEntity.setCategoryID(itemGroupDTO.getCategoryID());
            itemGroupEntity.setSubCategoryID(itemGroupDTO.getSubCategoryID());
            itemGroupEntity.setLastEditUser(itemGroupDTO.getLoginUser());
            int affectRow = itemGroupMapper.update(itemGroupEntity);
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
    public UnifiedResponse delete(int itemGroupID) {
        try {
            int affectRow = itemGroupMapper.delete(itemGroupID);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
