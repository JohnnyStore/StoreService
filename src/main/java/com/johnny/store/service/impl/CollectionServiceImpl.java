package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.CollectionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CollectionEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.manager.BuildViewModel;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.CollectionMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.ItemMapper;
import com.johnny.store.service.CollectionService;
import com.johnny.store.vo.CollectionVO;
import com.johnny.store.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private BuildViewModel buildViewModel;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String status) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<CollectionVO> modelList = new ArrayList<>();
            List<CollectionEntity> entityList =  collectionMapper.searchList(startIndex, pageSize, customerID, status.equals("A") ? null : status);
            for (CollectionEntity collectionEntity : entityList) {
                ItemEntity itemEntity = itemMapper.search(collectionEntity.getItemID());
                List<ImageEntity> imageEntityList = imageMapper.searchList(collectionEntity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }
                CollectionVO collectionVO = new CollectionVO();
                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
                ConvertObjectUtils.convertJavaBean(collectionVO, collectionEntity);

                collectionVO.setCollectionID(collectionEntity.getCollectionID());
                collectionVO.setItemID(collectionEntity.getItemID());
                collectionVO.setCustomerID(collectionEntity.getCustomerID());
                collectionVO.setItemVO(itemVO);
                modelList.add(collectionVO);
            }
            return UnifiedResponseManager.buildSuccessResponse(modelList.size(), modelList);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
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
    public UnifiedResponse add(Object dto) {
        try {
            CollectionDTO collectionDTO = (CollectionDTO)dto;
            CollectionEntity collectionEntity = new CollectionEntity();

            ConvertObjectUtils.convertJavaBean(collectionEntity, collectionDTO);
            collectionEntity.setCollectionID(collectionDTO.getCollectionID());
            collectionEntity.setItemID(collectionDTO.getItemID());
            collectionEntity.setCustomerID(collectionDTO.getCustomerID());
            collectionEntity.setStatus("I");
            collectionEntity.setInUser(collectionDTO.getLoginUser());
            collectionEntity.setLastEditUser(collectionDTO.getLoginUser());

            int affectRow = collectionMapper.insert(collectionEntity);
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
            CollectionDTO collectionDTO = (CollectionDTO)dto;
            CollectionEntity collectionEntity = new CollectionEntity();
            ConvertObjectUtils.convertJavaBean(collectionEntity, collectionDTO);
            collectionEntity.setCollectionID(collectionDTO.getCollectionID());
            collectionEntity.setStatus(collectionDTO.getStatus());
            collectionEntity.setLastEditUser(collectionDTO.getLoginUser());

            int affectRow = collectionMapper.update(collectionEntity);
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
            int affectRow = collectionMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}