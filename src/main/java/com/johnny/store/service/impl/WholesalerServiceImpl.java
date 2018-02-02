package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CustomerDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.dto.WholesalerDTO;
import com.johnny.store.entity.CustomerEntity;
import com.johnny.store.entity.WholesalerEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.WholesalerMapper;
import com.johnny.store.service.WholesalerService;
import com.johnny.store.vo.WholesalerVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WholesalerServiceImpl implements WholesalerService {
    @Autowired
    private WholesalerMapper wholesalerMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, String email, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<WholesalerVO> modelList= new ArrayList<>();
            int totalCount = wholesalerMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<WholesalerEntity> entityList = wholesalerMapper.searchList(
                    startIndex,
                    pageSize,
                    cellphone.equals("null") ? null : cellphone,
                    status.equals("null") ? null : status);
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (WholesalerEntity entity : entityList){
                WholesalerVO model = new WholesalerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                if(model.getStatus().equals("A")){
                    model.setActive(true);
                    model.setFrozen(false);
                }else{
                    model.setActive(false);
                    model.setFrozen(true);
                }
                model.setWholesalerID(entity.getWholesalerID());
                modelList.add(model);
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

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            WholesalerVO model = null;
            WholesalerEntity entity = wholesalerMapper.search(id);
            if (entity != null){
                model = new WholesalerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setWholesalerID(entity.getWholesalerID());
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
            WholesalerDTO wholesalerDTO = (WholesalerDTO)dto;
            WholesalerEntity wholesalerEntity = new WholesalerEntity();
            ConvertObjectUtils.convertJavaBean(wholesalerEntity, wholesalerDTO);
            wholesalerEntity.setInUser(wholesalerDTO.getLoginUser());
            wholesalerEntity.setLastEditUser(wholesalerDTO.getLoginUser());
            int affectRow = wholesalerMapper.insert(wholesalerEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    public UnifiedResponse changeStatus(Object dto){
        try {
            WholesalerDTO wholesalerDTO = (WholesalerDTO) dto;
            WholesalerEntity wholesalerEntity = new WholesalerEntity();
            ConvertObjectUtils.convertJavaBean(wholesalerEntity,wholesalerDTO);
            wholesalerEntity.setWholesalerID(wholesalerDTO.getWholesalerID());
            wholesalerEntity.setLastEditUser(wholesalerDTO.getLoginUser());
            int affectRow = wholesalerMapper.updateStatus(wholesalerEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    public UnifiedResponse changePassword(Object dto){
        try {
            WholesalerDTO wholesalerDTO = (WholesalerDTO) dto;
            WholesalerEntity wholesalerEntity = new WholesalerEntity();
            ConvertObjectUtils.convertJavaBean(wholesalerEntity,wholesalerDTO);
            wholesalerEntity.setWholesalerID(wholesalerDTO.getWholesalerID());
            wholesalerEntity.setLastEditUser(wholesalerDTO.getLoginUser());
            int affectRow = wholesalerMapper.updatePassword(wholesalerEntity);
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
            WholesalerDTO wholesalerDTO = (WholesalerDTO) dto;
            WholesalerEntity wholesalerEntity = new WholesalerEntity();
            ConvertObjectUtils.convertJavaBean(wholesalerEntity,wholesalerDTO);
            wholesalerEntity.setWholesalerID(wholesalerDTO.getWholesalerID());
            wholesalerEntity.setLastEditUser(wholesalerDTO.getLoginUser());
            int affectRow = wholesalerMapper.updateStatus(wholesalerEntity);
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
            int affectRow = wholesalerMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
