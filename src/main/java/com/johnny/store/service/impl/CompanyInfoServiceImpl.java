package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CompanyInfoDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CompanyInfoEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CompanyInfoMapper;
import com.johnny.store.service.CompanyInfoService;
import com.johnny.store.vo.CompanyInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    @Override
    public UnifiedResponse find(int infoID) {
        try {
            CompanyInfoVO model = null;
            CompanyInfoEntity entity = companyInfoMapper.search(infoID);
            if(entity != null){
                model = new CompanyInfoVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setInfoID(entity.getInfoID());
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
    public UnifiedResponse save(CompanyInfoDTO dto) {
        try {
//            int affectRow = 0;
            CompanyInfoEntity companyInfoEntity = new CompanyInfoEntity();
            ConvertObjectUtils.convertJavaBean(companyInfoEntity, dto);
            companyInfoEntity.setInUser(dto.getLoginUser());
            companyInfoEntity.setLastEditUser(dto.getLoginUser());

//            CompanyInfoEntity entity = companyInfoMapper.search(dto.getInfoID());
//            if(entity == null){
//                affectRow = companyInfoMapper.insert(companyInfoEntity);
//            }else{
//                affectRow = companyInfoMapper.update(companyInfoEntity);
//            }

            int affectRow4Delete = companyInfoMapper.delete(dto.getInfoID());
            int affectRow4Add = companyInfoMapper.insert(companyInfoEntity);
            int affectRow = affectRow4Delete + affectRow4Add;

            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
