package com.johnny.store.service.impl;

import com.johnny.store.common.*;
import com.johnny.store.config.SystemLogSetting;
import com.johnny.store.constant.ConfigFileConsts;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.constant.SystemLogStatusConsts;
import com.johnny.store.dto.SystemLogDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.SystemLogEntity;
import com.johnny.store.manager.ConfigManager;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.SystemLogMapper;
import com.johnny.store.service.SystemLogService;
import com.johnny.store.vo.SystemLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public UnifiedResponse findList(int pageIndex, int pageSize) {
        try {
            int startIndex = (pageIndex - 1) * pageSize;
            List<SystemLogVO> modelList = new ArrayList<>();
            int totalCount = systemLogMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<SystemLogEntity> entityList =  systemLogMapper.searchList(startIndex, pageSize);
            for (SystemLogEntity entity : entityList) {
                SystemLogVO model = new SystemLogVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setLogID(entity.getLogID());
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
            SystemLogVO model = null;
            SystemLogEntity entity = systemLogMapper.search(id);
            if(entity != null){
                model = new SystemLogVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setLogID(entity.getLogID());
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
            SystemLogDTO systemLogDTO = (SystemLogDTO)dto;
            SystemLogEntity entity = new SystemLogEntity();
            ConvertObjectUtils.convertJavaBean(entity, systemLogDTO);
            entity.setInUser(systemLogDTO.getLoginUser());
            entity.setLastEditUser(systemLogDTO.getLoginUser());
            entity.setStatus(SystemLogStatusConsts.INIT);
            int affectRow = systemLogMapper.insert(entity);
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
            SystemLogDTO systemLogDTO = (SystemLogDTO)dto;
            SystemLogEntity entity = new SystemLogEntity();
            entity.setLogID(systemLogDTO.getLogID());
            entity.setStatus(systemLogDTO.getStatus());
            entity.setLastEditUser(systemLogDTO.getLoginUser());
            int affectRow = systemLogMapper.updateStatus(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }
}