package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.entity.MaterialEntity;
import com.johnny.store.manager.BuildViewModel;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.ItemMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.MaterialMapper;
import com.johnny.store.service.ItemService;
import com.johnny.store.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private BuildViewModel buildViewModel;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemVO> modelList = new ArrayList<>();
            int totalCount = itemMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ItemEntity> entityList =  itemMapper.searchList(startIndex, pageSize);
            for (ItemEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemVO model = buildViewModel.buildItemViewModel(entity);
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
    public UnifiedResponse findSalesList(int pageNumber, int pageSize, int brandID, int categoryID, int subCategoryID) {
        try{
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemVO> modelList = new ArrayList<>();
            List<ItemEntity> entityList =  itemMapper.searchSalesList(startIndex, pageSize, brandID, categoryID, subCategoryID);

            for (ItemEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemVO model = buildViewModel.buildItemViewModel(entity);
                modelList.add(model);
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
    public UnifiedResponse findListByItemName(int pageNumber, int pageSize, String itemName) {
        try{
            int startIndex = (pageNumber - 1) * pageSize;
            List<ItemVO> modelList = new ArrayList<>();
            List<ItemEntity> entityList =  itemMapper.searchListByItemName(startIndex,pageSize, "%" + itemName + "%");

            for (ItemEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                ItemVO model = buildViewModel.buildItemViewModel(entity);
                modelList.add(model);
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
    public UnifiedResponse changeItemToShowInList(ItemDTO itemDTO) {
        try{
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setItemID(itemDTO.getItemID());
            itemEntity.setShowInListPage(itemDTO.getShowInListPage());
            itemEntity.setLastEditUser(itemDTO.getLoginUser());

            int affectRow = itemMapper.updateItemToShowInList(itemEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            ItemEntity entity = itemMapper.search(id);
            List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
            if(imageEntityList != null && imageEntityList.size() > 0){
                entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
            }

            ItemVO model = buildViewModel.buildItemViewModel(entity);
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
    public UnifiedResponse find(int brandID, int categoryID, int subCategoryID, int itemGroupID, int seriesID, int colorID, int sizeID) {
        try {
            ItemEntity entity = itemMapper.searchByParameters(brandID, categoryID, subCategoryID, itemGroupID, seriesID, colorID, sizeID);
            List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
            if(imageEntityList != null && imageEntityList.size() > 0){
                entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
            }

            ItemVO model = buildViewModel.buildItemViewModel(entity);
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
    public UnifiedResponse find(String itemCode) {
        try {
            ItemEntity entity = itemMapper.searchByItemCode(itemCode);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(null);
            }
            List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
            if(imageEntityList != null && imageEntityList.size() > 0){
                entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
            }
            ItemVO model = buildViewModel.buildItemViewModel(entity);
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
    public UnifiedResponse existCheck(String itemCode) {
        try {
            boolean exist = false;
            ItemEntity entity = itemMapper.searchByItemCode(itemCode);
            if(entity != null){
                exist = true;
            }
            return UnifiedResponseManager.buildSuccessResponse(exist);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    public UnifiedResponse existCheck(int brandID, int categoryID, int subCategoryID, int seriesID, String itemName) {
        try {
            boolean exist = false;
            ItemEntity entity = itemMapper.searchByItemName(brandID, categoryID, subCategoryID, seriesID, itemName);
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
            ItemDTO itemDTO = (ItemDTO)dto;
            ItemEntity itemEntity = new ItemEntity();

            ConvertObjectUtils.convertJavaBean(itemEntity, itemDTO);
            itemEntity.setItemID(itemDTO.getItemID());
            itemEntity.setBrandID(itemDTO.getBrandID());
            itemEntity.setCategoryID(itemDTO.getCategoryID());
            itemEntity.setSubCategoryID(itemDTO.getSubCategoryID());
            itemEntity.setItemGroupID(itemDTO.getItemGroupID());
            itemEntity.setSeriesID(itemDTO.getSeriesID());
            itemEntity.setUnitPrice4RMB(itemDTO.getUnitPrice4RMB());
            itemEntity.setPromotionPrice4RMB(itemDTO.getPromotionPrice4RMB());
            itemEntity.setUnitPrice4USD(itemDTO.getUnitPrice4USD());
            itemEntity.setPromotionPrice4USD(itemDTO.getPromotionPrice4USD());
            itemEntity.setRate(itemDTO.getRate());
            itemEntity.setColorID(itemDTO.getColorID());
            itemEntity.setSizeID(itemDTO.getSizeID());
            itemEntity.setMadeInID(itemDTO.getMadeInID());
            itemEntity.setInUser(itemDTO.getLoginUser());
            itemEntity.setLastEditUser(itemDTO.getLoginUser());

            int affectRow = itemMapper.insert(itemEntity);
            return UnifiedResponseManager.buildSuccessResponseWithID(affectRow, itemEntity.getItemID());
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
            ItemDTO itemDTO = (ItemDTO)dto;
            ItemEntity itemEntity = new ItemEntity();
            ConvertObjectUtils.convertJavaBean(itemEntity, itemDTO);
            itemEntity.setItemID(itemDTO.getItemID());
            itemEntity.setBrandID(itemDTO.getBrandID());
            itemEntity.setCategoryID(itemDTO.getCategoryID());
            itemEntity.setSubCategoryID(itemDTO.getSubCategoryID());
            itemEntity.setItemGroupID(itemDTO.getItemGroupID());
            itemEntity.setSeriesID(itemDTO.getSeriesID());
            itemEntity.setUnitPrice4RMB(itemDTO.getUnitPrice4RMB());
            itemEntity.setPromotionPrice4RMB(itemDTO.getPromotionPrice4RMB());
            itemEntity.setUnitPrice4USD(itemDTO.getUnitPrice4USD());
            itemEntity.setPromotionPrice4USD(itemDTO.getPromotionPrice4USD());
            itemEntity.setRate(itemDTO.getRate());
            itemEntity.setColorID(itemDTO.getColorID());
            itemEntity.setSizeID(itemDTO.getSizeID());
            itemEntity.setMadeInID(itemDTO.getMadeInID());
            itemEntity.setLastEditUser(itemDTO.getLoginUser());
            int affectRow = itemMapper.update(itemEntity);
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
            int affectRow = itemMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
