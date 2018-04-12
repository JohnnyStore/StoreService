package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.DateUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.dto.VerificationCodeDTO;
import com.johnny.store.entity.VerificationCodeEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.VerificationCodeMapper;
import com.johnny.store.service.VerificationCodeService;
import com.johnny.store.vo.VerificationCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeMapper verificationCodeMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        return null;
    }

    @Override
    public UnifiedResponse find(String cellphone, String email, String verificationCode) {
        try {
            VerificationCodeVO model = null;
            if(cellphone.equals("null")) cellphone = "";
            if(email.equals("null")) email = "";

            VerificationCodeEntity entity = verificationCodeMapper.search(cellphone, email, verificationCode);
            if (entity != null){
                model = new VerificationCodeVO();
                Date now = new Date();
                Date sendTime = DateUtils.convert(entity.getSendTime());
                long minutes = DateUtils.differenceMinutes(now, sendTime);
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setVerificationCodeID(entity.getVerificationCodeID());
                if(minutes > 5){
                    model.setExpired(true);
                }else{
                    model.setExpired(false);
                }
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
            VerificationCodeDTO verificationCodeDTO = (VerificationCodeDTO) dto;
            VerificationCodeEntity verificationCodeEntity = new VerificationCodeEntity();
            ConvertObjectUtils.convertJavaBean(verificationCodeEntity, verificationCodeDTO);
            int affectRow = verificationCodeMapper.insert(verificationCodeEntity);
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
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }
}
