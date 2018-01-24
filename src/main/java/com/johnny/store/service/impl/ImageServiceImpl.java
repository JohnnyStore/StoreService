package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.JsonUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ImageDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.service.ImageService;
import com.johnny.store.vo.ImageVO;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    public UnifiedResponse findList4Item(int objectID, String objectType) {
        try {
            List<ImageVO> modelList = new ArrayList<>();

            List<ImageEntity> entityList =  imageMapper.searchList4Item(objectID, objectType);
            for (ImageEntity entity : entityList) {
                ImageVO model = new ImageVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setObjectID(entity.getObjectID());
                model.setImageID(entity.getImageID());
                model.setGroupID(entity.getGroupID());
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

    public UnifiedResponse addList(String dtoListJson){
        try {
            List<Object> dtoList = JsonUtils.deserializeToObjectList(dtoListJson);
            int affectRowCount = 0;
            boolean deleted = false;
            for (Object dto : dtoList) {
                ImageDTO imageDTO = (ImageDTO) dto;
                ImageEntity imageEntity = new ImageEntity();

                ConvertObjectUtils.convertJavaBean(imageEntity, imageDTO);
                imageEntity.setObjectID(imageDTO.getObjectID());
                imageEntity.setGroupID(imageDTO.getGroupID());
                imageEntity.setInUser(imageDTO.getLoginUser());
                imageEntity.setLastEditUser(imageDTO.getLoginUser());
                if (!deleted) {
                    int affectRow4Delete = imageMapper.delete(imageDTO.getObjectID(), imageDTO.getObjectType(), imageDTO.getGroupID(), imageDTO.getImageType());
                    deleted = true;
                }

                int affectRow = imageMapper.insert(imageEntity);
                affectRowCount = affectRow + affectRow;
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRowCount);
        }
        catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        }
        catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try {
            ImageDTO imageDTO = (ImageDTO)dto;
            ImageEntity imageEntity = new ImageEntity();

            ConvertObjectUtils.convertJavaBean(imageEntity, imageDTO);
            imageEntity.setObjectID(imageDTO.getObjectID());
            imageEntity.setGroupID(imageDTO.getGroupID());
            imageEntity.setInUser(imageDTO.getLoginUser());
            imageEntity.setLastEditUser(imageDTO.getLoginUser());
            if(imageDTO.getObjectType().equals(ImageObjectType.ITEM) && imageDTO.getGroupID() != 0){
                int affectRow4Delete = imageMapper.delete(imageDTO.getObjectID(), imageDTO.getObjectType(), imageDTO.getGroupID(), imageDTO.getImageType());
            }

            int affectRow = imageMapper.insert(imageEntity);
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

    public UnifiedResponse deleteItemImage(int id, String objectType) {
        try {
            int affectRow = imageMapper.deleteItemImage(id, objectType);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
