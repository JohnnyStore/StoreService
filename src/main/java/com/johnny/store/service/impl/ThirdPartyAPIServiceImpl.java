package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ThirdPartyAPIDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ThirdPartyAPIEntity;
import com.johnny.store.entity.VerificationCodeEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ThirdPartyAPIMapper;
import com.johnny.store.mapper.VerificationCodeMapper;
import com.johnny.store.service.ThirdPartyAPIService;
import com.johnny.store.vo.ThirdPartyAPIVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThirdPartyAPIServiceImpl implements ThirdPartyAPIService {
    @Autowired
    private ThirdPartyAPIMapper thirdPartyAPIMapper;

    @Autowired
    private VerificationCodeMapper verificationCodeMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, String thirdParty, boolean result) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ThirdPartyAPIVO> modelList = new ArrayList<>();

            List<ThirdPartyAPIEntity> entityList =  thirdPartyAPIMapper.searchList(startIndex, pageSize, thirdParty, result);
            for (ThirdPartyAPIEntity entity : entityList) {
                ThirdPartyAPIVO model = new ThirdPartyAPIVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setRequestID(entity.getRequestID());
                model.setRequestResult(entity.isRequestResult());
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
        return null;
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(Object objDTO) {
        try {
            ThirdPartyAPIDTO dto = (ThirdPartyAPIDTO)objDTO;
            ThirdPartyAPIEntity entity = new ThirdPartyAPIEntity();
            VerificationCodeEntity verificationCodeEntity = new VerificationCodeEntity();

            ConvertObjectUtils.convertJavaBean(verificationCodeEntity, dto);
            ConvertObjectUtils.convertJavaBean(entity, dto);

            entity.setRequestResult(dto.getRequestResult().equals("T"));
            entity.setInUser(dto.getLoginUser());
            entity.setLastEditUser(dto.getLoginUser());

            int affectRow1 = 0;
            if(dto.getRequestResult().equals("T")){
                affectRow1 = verificationCodeMapper.insert(verificationCodeEntity);
            }

            int affectRow2 = thirdPartyAPIMapper.insert(entity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow1 + affectRow2);
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
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }
}
