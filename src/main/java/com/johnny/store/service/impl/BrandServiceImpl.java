package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.BrandDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.BrandEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CategoryMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.service.BrandService;
import com.johnny.store.vo.BrandVO;
import com.johnny.store.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<BrandVO> modelList = new ArrayList<>();
            int totalCount = brandMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<BrandEntity> entityList =  brandMapper.searchList(startIndex, pageSize);
            for (BrandEntity entity : entityList) {
                BrandVO model = new BrandVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setBrandID(entity.getBrandID());
                model.setImageID(entity.getImageID());
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
            BrandVO model = null;
            BrandEntity entity = brandMapper.search(id);
            if(entity != null){
                model = new BrandVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
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
        try {
            boolean exist = false;
            BrandEntity entity = brandMapper.searchByName(name);
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
            BrandDTO brandDTO = (BrandDTO)dto;
            BrandEntity brandEntity = new BrandEntity();
            ImageEntity imageEntity = new ImageEntity();
            ConvertObjectUtils.convertJavaBean(brandEntity, brandDTO);
            brandEntity.setInUser(brandDTO.getLoginUser());
            brandEntity.setLastEditUser(brandDTO.getLoginUser());
            int affectRow = brandMapper.insert(brandEntity);

            imageEntity.setImageSrc(brandDTO.getBrandImageUrl());
            imageEntity.setParentImageSrc("");
            imageEntity.setObjectID(brandEntity.getBrandID());
            imageEntity.setObjectType(ImageObjectType.BRAND);
            imageEntity.setImageType(ImageType.NORMAL);
            imageEntity.setInUser(brandDTO.getLoginUser());
            imageEntity.setLastEditUser(brandDTO.getLoginUser());
            imageMapper.insert(imageEntity);
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
            BrandDTO brandDTO = (BrandDTO)dto;
            BrandEntity brandEntity = new BrandEntity();
            ImageEntity imageEntity = new ImageEntity();

            ConvertObjectUtils.convertJavaBean(brandEntity, brandDTO);
            brandEntity.setBrandID(brandDTO.getBrandID());
            brandEntity.setLastEditUser(brandDTO.getLoginUser());
            int affectRow = brandMapper.update(brandEntity);

            imageEntity.setImageID(brandDTO.getBrandImageID());
            imageEntity.setImageSrc(brandDTO.getBrandImageUrl());
            imageEntity.setParentImageSrc("");
            imageEntity.setLastEditUser(brandDTO.getLoginUser());
            int affectRow4Image = imageMapper.update(imageEntity);
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
            int affectRow = brandMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
