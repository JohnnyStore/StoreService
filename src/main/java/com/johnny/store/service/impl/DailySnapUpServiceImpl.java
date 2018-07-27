package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.DateUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.DailySnapUpDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.DailySnapUpEntity;
import com.johnny.store.entity.ImageEntity;
import com.johnny.store.enums.DateEnum;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.DailySnapUpMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.service.DailySnapUpService;
import com.johnny.store.vo.DailySnapUpListVO;
import com.johnny.store.vo.DailySnapUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailySnapUpServiceImpl implements DailySnapUpService {
    @Autowired
    private DailySnapUpMapper dailySnapUpMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, String snapUpDate, String status) {
        try{
            int startIndex = (pageNumber - 1) * pageSize;
            List<DailySnapUpVO> modelList = new ArrayList<>();

            int totalCount = dailySnapUpMapper.searchTotalCount(snapUpDate.equals("N")? null: snapUpDate, status.equals("N")? null: status);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<DailySnapUpEntity> entityList = dailySnapUpMapper.searchList(
                    startIndex,
                    pageSize,
                    snapUpDate.equals("N")? null: snapUpDate,
                    status.equals("N")? null: status);
            for (DailySnapUpEntity entity : entityList) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                DailySnapUpVO model = new DailySnapUpVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSnapUpID(entity.getSnapUpID());
                model.setItemID(entity.getItemID());
                model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
                model.setUnitPrice4USD(entity.getUnitPrice4USD());
                model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        }catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findCurrentDailySnapUp() {
        try{
            DailySnapUpListVO dailySnapUpListVO = new DailySnapUpListVO();
            List<DailySnapUpVO> modelListOfYesterday = new ArrayList<>();
            List<DailySnapUpVO> modelListOfToday = new ArrayList<>();
            List<DailySnapUpVO> modelListOfTomorrow = new ArrayList<>();
            List<DailySnapUpVO> modelListOfAfterTomorrow = new ArrayList<>();

            String yesterday = DateUtils.calculateDate(DateEnum.Day, -1).substring(0, 10);
            String today = DateUtils.getCurrentDateTime().substring(0, 10);
            String tomorrow = DateUtils.calculateDate(DateEnum.Day, 1).substring(0, 10);
            String afterTomorrow = DateUtils.calculateDate(DateEnum.Day, 2).substring(0, 10);

            //昨天
            List<DailySnapUpEntity> entityListOfYesterday = dailySnapUpMapper.searchBySnapUpDate(yesterday);
            for (DailySnapUpEntity entity : entityListOfYesterday) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                DailySnapUpVO model = new DailySnapUpVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSnapUpID(entity.getSnapUpID());
                model.setItemID(entity.getItemID());
                model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
                model.setUnitPrice4USD(entity.getUnitPrice4USD());
                model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
                modelListOfYesterday.add(model);
            }
            //今天
            List<DailySnapUpEntity> entityListOfToday = dailySnapUpMapper.searchBySnapUpDate(today);
            for (DailySnapUpEntity entity : entityListOfToday) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                DailySnapUpVO model = new DailySnapUpVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSnapUpID(entity.getSnapUpID());
                model.setItemID(entity.getItemID());
                model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
                model.setUnitPrice4USD(entity.getUnitPrice4USD());
                model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
                modelListOfToday.add(model);
            }
            //明天
            List<DailySnapUpEntity> entityListOfTomorrow = dailySnapUpMapper.searchBySnapUpDate(tomorrow);
            for (DailySnapUpEntity entity : entityListOfTomorrow) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                DailySnapUpVO model = new DailySnapUpVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSnapUpID(entity.getSnapUpID());
                model.setItemID(entity.getItemID());
                model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
                model.setUnitPrice4USD(entity.getUnitPrice4USD());
                model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
                modelListOfTomorrow.add(model);
            }
            //后天
            List<DailySnapUpEntity> entityListOfAfterTomorrow = dailySnapUpMapper.searchBySnapUpDate(afterTomorrow);
            for (DailySnapUpEntity entity : entityListOfAfterTomorrow) {
                List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }

                DailySnapUpVO model = new DailySnapUpVO();
                ConvertObjectUtils.convertJavaBean(model, entity);
                model.setSnapUpID(entity.getSnapUpID());
                model.setItemID(entity.getItemID());
                model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
                model.setUnitPrice4USD(entity.getUnitPrice4USD());
                model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
                modelListOfAfterTomorrow.add(model);
            }
            dailySnapUpListVO.setDailySnapUpOfYesterday(modelListOfYesterday);
            dailySnapUpListVO.setDailySnapUpOfToday(modelListOfToday);
            dailySnapUpListVO.setDailySnapUpOfTomorrow(modelListOfTomorrow);
            dailySnapUpListVO.setDailySnapUpOfAfterTomorrow(modelListOfAfterTomorrow);

            return UnifiedResponseManager.buildSuccessResponse(1, dailySnapUpListVO);
        }catch (StoreException ex){
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
        try{
            List<DailySnapUpVO> modelList = new ArrayList<>();

            DailySnapUpEntity entity = dailySnapUpMapper.search(id);
            if(entity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<ImageEntity> imageEntityList = imageMapper.searchList(entity.getItemID(), ImageObjectType.ITEM, ImageType.NORMAL);
            if(imageEntityList != null && imageEntityList.size() > 0){
                entity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
            }

            DailySnapUpVO model = new DailySnapUpVO();
            ConvertObjectUtils.convertJavaBean(model, entity);
            model.setSnapUpID(entity.getSnapUpID());
            model.setItemID(entity.getItemID());
            model.setSnapUpPrice4RMB(entity.getSnapUpPrice4RMB());
            model.setSnapUpPrice4USD(entity.getSnapUpPrice4USD());
            modelList.add(model);
            return UnifiedResponseManager.buildSuccessResponse(1, model);
        }catch (StoreException ex){
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
            DailySnapUpDTO dailySnapUpDTO = (DailySnapUpDTO)dto;
            DailySnapUpEntity dailySnapUpEntity = new DailySnapUpEntity();
            ConvertObjectUtils.convertJavaBean(dailySnapUpEntity, dailySnapUpDTO);
            dailySnapUpEntity.setSnapUpID(dailySnapUpDTO.getSnapUpID());
            dailySnapUpEntity.setItemID(dailySnapUpDTO.getItemID());
            dailySnapUpEntity.setSnapUpPrice4RMB(dailySnapUpDTO.getSnapUpPrice4RMB());
            dailySnapUpEntity.setSnapUpPrice4USD(dailySnapUpDTO.getSnapUpPrice4USD());
            dailySnapUpEntity.setInUser(dailySnapUpDTO.getLoginUser());
            dailySnapUpEntity.setLastEditUser(dailySnapUpDTO.getLoginUser());
            int affectRow = dailySnapUpMapper.insert(dailySnapUpEntity);
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
            DailySnapUpDTO dailySnapUpDTO = (DailySnapUpDTO)dto;
            DailySnapUpEntity dailySnapUpEntity = new DailySnapUpEntity();
            ConvertObjectUtils.convertJavaBean(dailySnapUpEntity, dailySnapUpDTO);
            dailySnapUpEntity.setSnapUpID(dailySnapUpDTO.getSnapUpID());
            dailySnapUpEntity.setItemID(dailySnapUpDTO.getItemID());
            dailySnapUpEntity.setSnapUpPrice4RMB(dailySnapUpDTO.getSnapUpPrice4RMB());
            dailySnapUpEntity.setSnapUpPrice4USD(dailySnapUpDTO.getSnapUpPrice4USD());
            dailySnapUpEntity.setInUser(dailySnapUpDTO.getLoginUser());
            dailySnapUpEntity.setLastEditUser(dailySnapUpDTO.getLoginUser());
            int affectRow = dailySnapUpMapper.update(dailySnapUpEntity);
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
            int affectRow = dailySnapUpMapper.delete(id);
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
