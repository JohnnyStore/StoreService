package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CustomerDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CustomerEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CustomerMapper;
import com.johnny.store.service.CustomerService;
import com.johnny.store.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CustomerVO> modelList= new ArrayList<>();
            int totalCount = customerMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<CustomerEntity> entityList = customerMapper.searchList(
                    startIndex,
                    pageSize,
                    cellphone.equals("null") ? null : cellphone,
                    status.equals("null") ? null : status);
            if (entityList.isEmpty()){
                return UnifiedResponseManager.buildFailedResponse(null);
            }
            for (CustomerEntity entity : entityList){
                CustomerVO model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                if(model.getStatus().equals("A")){
                    model.setActive(true);
                    model.setFrozen(false);
                }else{
                    model.setActive(false);
                    model.setFrozen(true);
                }
                model.setCustomerID(entity.getCustomerID());
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
    public UnifiedResponse login(String userName, String password) {
        try {
            CustomerVO model = null;
            CustomerEntity entity = customerMapper.login(userName, password);
            if (entity != null){
                model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                if(model.getStatus().equals("A")){
                    model.setActive(true);
                    model.setFrozen(false);
                }else{
                    model.setActive(false);
                    model.setFrozen(true);
                }
                model.setCustomerID(entity.getCustomerID());
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
    public UnifiedResponse findByAccount(String account) {
        try {
            CustomerVO model = null;
            CustomerEntity entity = customerMapper.searchByAccount(account);
            if (entity != null){
                model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setCustomerID(entity.getCustomerID());
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
    public UnifiedResponse findByCellphone(String cellphone) {
        try {
            CustomerVO model = null;
            CustomerEntity entity = customerMapper.searchByCellphone(cellphone);
            if (entity != null){
                model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setCustomerID(entity.getCustomerID());
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
    public UnifiedResponse findByEmail(String email) {
        try {
            CustomerVO model = null;
            CustomerEntity entity = customerMapper.searchByEmail(email);
            if (entity != null){
                model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setCustomerID(entity.getCustomerID());
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
    public UnifiedResponse find(int id) {
        try {
            CustomerVO model = null;
            CustomerEntity entity = customerMapper.search(id);
            if (entity != null){
                model = new CustomerVO();
                ConvertObjectUtils.convertJavaBean(model,entity);
                model.setCustomerID(entity.getCustomerID());
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
            CustomerDTO customerDTO = (CustomerDTO)dto;
            CustomerEntity customerEntity = new CustomerEntity();
            ConvertObjectUtils.convertJavaBean(customerEntity, customerDTO);
            if(customerDTO.getCustomerType().equals("N")){
                customerEntity.setStatus("A");
            }else{
                customerEntity.setStatus("P");
            }
            customerEntity.setInUser(customerDTO.getLoginUser());
            customerEntity.setLastEditUser(customerDTO.getLoginUser());
            int affectRow = customerMapper.insert(customerEntity);
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
            CustomerDTO customerDTO = (CustomerDTO) dto;
            CustomerEntity customerEntity = new CustomerEntity();
            ConvertObjectUtils.convertJavaBean(customerEntity,customerDTO);
            customerEntity.setCustomerID(customerDTO.getCustomerID());
            customerEntity.setLastEditUser(customerDTO.getLoginUser());
            int affectRow = customerMapper.updateStatus(customerEntity);
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
            CustomerDTO customerDTO = (CustomerDTO) dto;
            CustomerEntity customerEntity = new CustomerEntity();
            ConvertObjectUtils.convertJavaBean(customerEntity,customerDTO);
            customerEntity.setCustomerID(customerDTO.getCustomerID());
            customerEntity.setLastEditUser(customerDTO.getLoginUser());
            int affectRow = customerMapper.updatePassword(customerEntity);
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
            CustomerDTO customerDTO = (CustomerDTO) dto;
            CustomerEntity customerEntity = new CustomerEntity();
            ConvertObjectUtils.convertJavaBean(customerEntity,customerDTO);
            customerEntity.setCustomerID(customerDTO.getCustomerID());
            customerEntity.setLastEditUser(customerDTO.getLoginUser());
            int affectRow = customerMapper.update(customerEntity);
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
            int affectRow = customerMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
