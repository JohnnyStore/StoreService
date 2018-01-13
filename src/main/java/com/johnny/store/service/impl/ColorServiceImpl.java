package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ColorDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ColorEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ColorMapper;
import com.johnny.store.service.ColorService;
import com.johnny.store.vo.ColorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService{
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ColorVO> modelList = new ArrayList<>();
            int totalCount = colorMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ColorEntity> entityList =  colorMapper.searchList(startIndex, pageSize);
            for (ColorEntity entity : entityList) {
                ColorVO model = new ColorVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setColorID(entity.getColorID());
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
            ColorVO model = null;
            ColorEntity entity = colorMapper.search(id);
            if(entity != null){
                model = new ColorVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setColorID(entity.getColorID());
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
            ColorEntity entity = colorMapper.searchByName(name);
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
            ColorDTO colorDTO = (ColorDTO)dto;
            ColorEntity colorEntity = new ColorEntity();
            ConvertObjectUtils.convertJavaBean(colorEntity, colorDTO);
            colorEntity.setInUser(colorDTO.getLoginUser());
            colorEntity.setLastEditUser(colorDTO.getLoginUser());
            int affectRow = colorMapper.insert(colorEntity);
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
            ColorDTO colorDTO = (ColorDTO)dto;
            ColorEntity colorEntity = new ColorEntity();
            ConvertObjectUtils.convertJavaBean(colorEntity, colorDTO);
            colorEntity.setColorID(colorDTO.getColorID());
            colorEntity.setLastEditUser(colorDTO.getLoginUser());
            int affectRow = colorMapper.update(colorEntity);
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
            int affectRow = colorMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
