package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ExpressCompanyDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ExpressCompanyEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ExpressCompanyMapper;
import com.johnny.store.service.ExpressCompanyService;
import com.johnny.store.vo.ExpressCompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpressCompanyServiceImpl implements ExpressCompanyService{
    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ExpressCompanyVO> modelList = new ArrayList<>();
            int totalCount = expressCompanyMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ExpressCompanyEntity> entityList =  expressCompanyMapper.searchList(startIndex, pageSize);
            if(entityList.isEmpty()){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            for (ExpressCompanyEntity entity : entityList) {
                ExpressCompanyVO model = new ExpressCompanyVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCompanyID(entity.getCompanyID());
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
    public UnifiedResponse find(int id) {
        try {
            ExpressCompanyVO model = null;
            ExpressCompanyEntity entity = expressCompanyMapper.search(id);
            if(entity != null){
                model = new ExpressCompanyVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setCompanyID(entity.getCompanyID());
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
            ExpressCompanyEntity entity = expressCompanyMapper.searchByName(name);
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
            ExpressCompanyDTO expressCompanyDTO = (ExpressCompanyDTO)dto;
            ExpressCompanyEntity expressCompanyEntity = new ExpressCompanyEntity();
            ConvertObjectUtils.convertJavaBean(expressCompanyEntity, expressCompanyDTO);
            expressCompanyEntity.setInUser(expressCompanyDTO.getLoginUser());
            expressCompanyEntity.setLastEditUser(expressCompanyDTO.getLoginUser());
            int affectRow = expressCompanyMapper.insert(expressCompanyEntity);
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
            ExpressCompanyDTO expressCompanyDTO = (ExpressCompanyDTO)dto;
            ExpressCompanyEntity expressCompanyEntity = new ExpressCompanyEntity();
            ConvertObjectUtils.convertJavaBean(expressCompanyEntity, expressCompanyDTO);
            expressCompanyEntity.setCompanyID(expressCompanyDTO.getCompanyID());
            expressCompanyEntity.setLastEditUser(expressCompanyDTO.getLoginUser());
            int affectRow = expressCompanyMapper.update(expressCompanyEntity);
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
            int affectRow = expressCompanyMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}

