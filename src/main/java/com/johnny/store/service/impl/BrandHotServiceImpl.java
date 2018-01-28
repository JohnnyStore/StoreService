package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BrandHotDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.BrandHotEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BrandHotMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.service.BrandHotService;
import com.johnny.store.vo.BrandHotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandHotServiceImpl implements BrandHotService {

    @Autowired
    private BrandHotMapper brandHotMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BrandHotVO> modelList = new ArrayList<>();
            int totalCount = brandHotMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BrandHotEntity> entityList =  brandHotMapper.searchList(startIndex, pageSize);
            for (BrandHotEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getBrandID(), ImageObjectType.BRAND, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setBrandImageUrl(imageEntityList.get(0).getImageSrc());
                }

                BrandHotVO model = new BrandHotVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setBrandHotID(entity.getBrandHotID());
                model.setBrandID(entity.getBrandID());
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
            BrandHotVO model = null;
            BrandHotEntity entity = brandHotMapper.search(id);
            if(entity != null){
                model = new BrandHotVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setBrandHotID(entity.getBrandHotID());
                model.setBrandID(entity.getBrandID());
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
            BrandHotDTO brandHotDTO = (BrandHotDTO)dto;
            BrandHotEntity brandHotEntity = new BrandHotEntity();
            ConvertObjectUtils.convertJavaBean(brandHotEntity, brandHotDTO);
            brandHotEntity.setBrandHotID(brandHotDTO.getBrandHotID());
            brandHotEntity.setBrandID(brandHotDTO.getBrandID());
            brandHotEntity.setInUser(brandHotDTO.getLoginUser());
            brandHotEntity.setLastEditUser(brandHotDTO.getLoginUser());
            int affectRow = brandHotMapper.insert(brandHotEntity);
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
            BrandHotDTO brandHotDTO = (BrandHotDTO)dto;
            BrandHotEntity brandHotEntity = new BrandHotEntity();
            ConvertObjectUtils.convertJavaBean(brandHotEntity, brandHotDTO);
            brandHotEntity.setBrandHotID(brandHotDTO.getBrandHotID());
            brandHotEntity.setBrandID(brandHotDTO.getBrandID());
            brandHotEntity.setLastEditUser(brandHotDTO.getLoginUser());
            int affectRow = brandHotMapper.update(brandHotEntity);
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
            int affectRow = brandHotMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
