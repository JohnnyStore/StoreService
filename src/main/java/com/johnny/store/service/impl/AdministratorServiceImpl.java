package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ApprovedStatusConsts;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.AdministratorDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.AdministratorEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.AdministratorMapper;
import com.johnny.store.service.AdministratorService;
import com.johnny.store.vo.AdministratorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员信息逻辑层
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public UnifiedResponse checkAccountIsExists(String account) {
        try {
            boolean exist = false;
            int rowCount = administratorMapper.searchTotalCount4Account(account);
            if(rowCount != 0){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse checkCellphoneIsExists(String cellphone) {
        try {
            boolean exist = false;
            int rowCount = administratorMapper.searchTotalCount4Cellphone(cellphone);
            if(rowCount != 0){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse checkEmailIsExists(String email) {
        try {
            boolean exist = false;
            int rowCount = administratorMapper.searchTotalCount4Email(email);
            if(rowCount != 0){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse login(String userName, String password) {
        try {
            String responseCode;
            AdministratorEntity entity = administratorMapper.search4Login(userName, password);
            if(entity == null){
                responseCode = ResponseCodeConsts.LOGIN_FAILED;
            }else if(entity.getStatus().equals(ApprovedStatusConsts.PADDING)){
                responseCode = ResponseCodeConsts.LOGIN_CHECKING;
            }else if(entity.getStatus().equals(ApprovedStatusConsts.NOPASS)){
                responseCode = ResponseCodeConsts.LOGIN_CHECKING_NOPASS;
            }else if(entity.getStatus().equals(ApprovedStatusConsts.FROZEN)){
                responseCode = ResponseCodeConsts.ACCOUNT_FROZEN;
            }else{
                responseCode = ResponseCodeConsts.LOGIN_SUCCESS;
            }

            return UnifiedResponseManager.buildSuccessResponse(responseCode, entity);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<AdministratorVO> modelList = new ArrayList<>();
            int totalCount = administratorMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<AdministratorEntity> entityList =  administratorMapper.searchList(startIndex, pageSize);
            for (AdministratorEntity entity : entityList) {
                transform(entity);
                AdministratorVO model = new AdministratorVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setAdministratorID(entity.getAdministratorID());
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
            AdministratorVO model = null;
            AdministratorEntity entity = administratorMapper.search(id);
            if(entity != null){
                transform(entity);
                model = new AdministratorVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setAdministratorID(entity.getAdministratorID());
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
            AdministratorEntity entity = administratorMapper.searchByName(name);
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
            AdministratorDTO administratorDTO = (AdministratorDTO)dto;
            AdministratorEntity entity = new AdministratorEntity();
            ConvertObjectUtils.convertJavaBean(entity, administratorDTO);
            entity.setCustomerRole("");
            entity.setStatus(ApprovedStatusConsts.PADDING);
            entity.setInUser(administratorDTO.getLoginUser());
            entity.setLastEditUser(administratorDTO.getLoginUser());
            int affectRow = administratorMapper.insert(entity);
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
            AdministratorDTO administratorDTO = (AdministratorDTO)dto;
            AdministratorEntity entity = new AdministratorEntity();
            ConvertObjectUtils.convertJavaBean(entity, administratorDTO);
            entity.setAdministratorID(administratorDTO.getAdministratorID());
            entity.setLastEditUser(administratorDTO.getLoginUser());
            int affectRow = administratorMapper.update(entity);
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
    public UnifiedResponse approve(AdministratorDTO dto) {
        try {
            AdministratorEntity entity = new AdministratorEntity();
            transformToKey(entity);
            ConvertObjectUtils.convertJavaBean(entity, dto);
            entity.setAdministratorID(dto.getAdministratorID());
            entity.setLastEditUser(dto.getLoginUser());
            int affectRow = administratorMapper.approve(entity);
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
            int affectRow = administratorMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    public AdministratorEntity transform(AdministratorEntity administratorEntity){
        String tranStatus = administratorEntity.getStatus();
        switch(tranStatus){
            case "P":
                tranStatus = "待审核";
                break;
            case "A":
                tranStatus = "审核通过";
                break;
            case "N":
                tranStatus = "审核未通过";
                break;
            case "F":
                tranStatus = "冻结";
                break;
            default:
                break;
        }
        administratorEntity.setStatus(tranStatus);
        String tranCustomerRole = administratorEntity.getCustomerRole();
        switch(tranCustomerRole){
            case "S":
                tranCustomerRole = "最高权限";
                break;
            case "C":
                tranCustomerRole = "修改权限";
                break;
            case "Q":
                tranCustomerRole = "查询权限";
                break;
            default:
                break;
        }
        administratorEntity.setCustomerRole(tranCustomerRole);
        return administratorEntity;
    }

    public AdministratorEntity transformToKey(AdministratorEntity administratorEntity){
        String tranStatus = administratorEntity.getStatus();
        switch(tranStatus){
            case "待审核":
                tranStatus = "P";
                break;
            case "审核通过":
                tranStatus = "A";
                break;
            case "审核未通过":
                tranStatus = "N";
                break;
            case "冻结":
                tranStatus = "F";
                break;
            default:
                break;
        }
        administratorEntity.setStatus(tranStatus);
        String tranCustomerRole = administratorEntity.getCustomerRole();
        switch(tranCustomerRole){
            case "最高权限":
                tranCustomerRole = "S";
                break;
            case "修改权限":
                tranCustomerRole = "C";
                break;
            case "查询权限":
                tranCustomerRole = "Q";
                break;
            default:
                break;
        }
        administratorEntity.setCustomerRole(tranCustomerRole);
        return administratorEntity;
    }
}
