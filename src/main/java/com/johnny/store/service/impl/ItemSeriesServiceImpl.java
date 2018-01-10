package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemSeriesDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ItemSeriesEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ItemSeriesMapper;
import com.johnny.store.service.ItemSeriesService;
import com.johnny.store.vo.ItemSeriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemSeriesServiceImpl implements ItemSeriesService {
    @Autowired
    private ItemSeriesMapper itemSeriesMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemSeriesVO> modelList = new ArrayList<>();
            int totalCount = itemSeriesMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemSeriesEntity> entityList =  itemSeriesMapper.searchList(startIndex, pageSize);
            for (ItemSeriesEntity entity : entityList) {
                ItemSeriesVO model = new ItemSeriesVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSeriesID(entity.getSeriesID());
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
            ItemSeriesVO model = null;
            ItemSeriesEntity entity = itemSeriesMapper.search(id);
            if(entity != null){
                model = new ItemSeriesVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSeriesID(entity.getSeriesID());
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
        try {
            boolean exist = false;
            ItemSeriesEntity entity = itemSeriesMapper.searchByName(name);
            if(entity != null){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try {
            ItemSeriesDTO itemSeriesDTO = (ItemSeriesDTO)dto;
            ItemSeriesEntity itemSeriesEntity = new ItemSeriesEntity();
            ConvertObjectUtils.convertJavaBean(itemSeriesEntity, itemSeriesDTO);
            itemSeriesEntity.setInUser(itemSeriesDTO.getLoginUser());
            itemSeriesEntity.setLastEditUser(itemSeriesDTO.getLoginUser());
            int affectRow = itemSeriesMapper.insert(itemSeriesEntity);
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
            ItemSeriesDTO itemSeriesDTO = (ItemSeriesDTO)dto;
            ItemSeriesEntity itemSeriesEntity = new ItemSeriesEntity();
            ConvertObjectUtils.convertJavaBean(itemSeriesEntity, itemSeriesDTO);
            itemSeriesEntity.setSeriesID(itemSeriesDTO.getSeriesID());
            itemSeriesEntity.setLastEditUser(itemSeriesDTO.getLoginUser());
            int affectRow = itemSeriesMapper.update(itemSeriesEntity);
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
            int affectRow = itemSeriesMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
