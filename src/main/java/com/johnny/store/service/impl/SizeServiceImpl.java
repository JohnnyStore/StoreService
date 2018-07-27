package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.SizeDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.SizeEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.SizeMapper;
import com.johnny.store.service.SizeService;
import com.johnny.store.vo.SizeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeServiceImpl implements SizeService{
    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<SizeVO> modelList = new ArrayList<>();
            int totalCount = sizeMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<SizeEntity> entityList =  sizeMapper.searchList(startIndex, pageSize);
            for (SizeEntity entity : entityList) {
                SizeVO model = new SizeVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSizeID(entity.getSizeID());
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
    public UnifiedResponse findList(int itemID, int seriesID, int colorID) {
        try {
            List<SizeVO> modelList = new ArrayList<>();
            List<SizeEntity> entityList =  sizeMapper.searchList4Item(itemID, seriesID, colorID);
            for (SizeEntity entity : entityList) {
                SizeVO model = new SizeVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSizeID(entity.getSizeID());
                modelList.add(model);
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
            SizeVO model = null;
            SizeEntity entity = sizeMapper.search(id);
            if(entity != null){
                model = new SizeVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSizeID(entity.getSizeID());
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
            SizeEntity entity = sizeMapper.searchByName(name);
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
            SizeDTO sizeDTO = (SizeDTO)dto;
            SizeEntity sizeEntity = new SizeEntity();
            ConvertObjectUtils.convertJavaBean(sizeEntity, sizeDTO);
            sizeEntity.setInUser(sizeDTO.getLoginUser());
            sizeEntity.setLastEditUser(sizeDTO.getLoginUser());
            int affectRow = sizeMapper.insert(sizeEntity);
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
            SizeDTO sizeDTO = (SizeDTO)dto;
            SizeEntity sizeEntity = new SizeEntity();
            ConvertObjectUtils.convertJavaBean(sizeEntity, sizeDTO);
            sizeEntity.setSizeID(sizeDTO.getSizeID());
            sizeEntity.setLastEditUser(sizeDTO.getLoginUser());
            int affectRow = sizeMapper.update(sizeEntity);
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
            int affectRow = sizeMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
