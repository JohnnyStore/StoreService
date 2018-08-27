package com.johnny.store.service.impl;

import com.johnny.store.common.JsonUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.NewsContentDTO;
import com.johnny.store.dto.NewsDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.NewsContentEntity;
import com.johnny.store.entity.NewsEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.NewsContentMapper;
import com.johnny.store.mapper.NewsMapper;
import com.johnny.store.service.NewsService;
import com.johnny.store.vo.NewsContentVO;
import com.johnny.store.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsContentMapper newsContentMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<NewsVO> modelList = new ArrayList<>();
            int totalCount = newsMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            List<NewsEntity> entityList =  newsMapper.searchList(startIndex, pageSize);
            for (NewsEntity entity : entityList) {
                modelList.add(convertEntityToVo(entity));
            }
            return UnifiedResponseManager.buildSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse find(int id) {
        try {
            NewsEntity entity =  newsMapper.search(id);
            NewsVO model = convertEntityToVo(entity);
            return UnifiedResponseManager.buildSuccessResponse(model != null ? 1 : 0, model);
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
            NewsDTO newsDTO = (NewsDTO) dto;
            NewsEntity entity = convertDtoToEntity(newsDTO);
            NewsContentEntity contentEntity;
            List<NewsContentDTO> newsContentList = JsonUtils.deserializationToObject(newsDTO.getNewsContentJson(), NewsContentDTO.class);
            int affectRow = newsMapper.insert(entity);
            for (NewsContentDTO contentDTO : newsContentList) {
                contentEntity = convertDtoToEntity(contentDTO, entity.getNewsID());
                int affectRow4Content = newsContentMapper.insert(contentEntity);
                affectRow += affectRow4Content;
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(Object dto) {
        try {
            NewsDTO newsDTO = (NewsDTO) dto;
            NewsEntity entity = convertDtoToEntity(newsDTO);
            NewsContentEntity contentEntity;
            List<NewsContentDTO> newsContentList = JsonUtils.deserializationToObject(newsDTO.getNewsContentJson(), NewsContentDTO.class);
            int affectRow = newsMapper.update(entity);
            int affectDeleteRow = newsContentMapper.delete(newsDTO.getNewsID());
            affectRow += affectDeleteRow;
            for (NewsContentDTO contentDTO : newsContentList) {
                contentEntity = convertDtoToEntity(contentDTO, entity.getNewsID());
                int affectRow4Content = newsContentMapper.insert(contentEntity);
                affectRow += affectRow4Content;
            }
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = newsMapper.delete(id);
            int affect4ContentRow = newsContentMapper.delete(id);
            affectRow += affect4ContentRow;
            return UnifiedResponseManager.buildSuccessResponse(affectRow);
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public NewsContentEntity convertDtoToEntity(NewsContentDTO dto, int newsID) {
        NewsContentEntity entity = new NewsContentEntity();
        entity.setNewsContentID(dto.getNewsContentID());
        entity.setNewsID(newsID);
        entity.setNewsContentType(dto.getNewsContentType());
        entity.setNewsContent(dto.getNewsContent());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    @Override
    public NewsVO convertEntityToVo(NewsEntity entity) {
        if(entity == null){
            return null;
        }
        List<NewsContentEntity> newsContentEntityList = newsContentMapper.searchList4News(entity.getNewsID());


        NewsVO newsVO = new NewsVO();
        List<NewsContentVO> newsContentVOList = convertEntityToVO(newsContentEntityList);
        newsVO.setNewsID(entity.getNewsID());
        newsVO.setThumbnailUrl(entity.getThumbnailUrl());
        newsVO.setNewsTitle(entity.getNewsTitle());
        newsVO.setNewsDate(entity.getNewsDate());
        newsVO.setNewsContentList(newsContentVOList);
        newsVO.setStatus(entity.getStatus());
        newsVO.setInDate(entity.getInDate());
        newsVO.setInUser(entity.getInUser());
        newsVO.setLastEditDate(entity.getLastEditDate());
        newsVO.setLastEditUser(entity.getLastEditUser());
        return newsVO;
    }

    @Override
    public NewsEntity convertDtoToEntity(NewsDTO dto) {
        NewsEntity entity = new NewsEntity();
        entity.setNewsID(dto.getNewsID());
        entity.setThumbnailUrl(dto.getThumbnailUrl());
        entity.setNewsTitle(dto.getNewsTitle());
        entity.setNewsDate(dto.getNewsDate());
        entity.setStatus(dto.getStatus());
        entity.setInUser(dto.getLoginUser());
        entity.setLastEditUser(dto.getLoginUser());
        return entity;
    }

    private static List<NewsContentVO> convertEntityToVO(List<NewsContentEntity> entityList){
        if(entityList.isEmpty()){
            return null;
        }
        List<NewsContentVO> newsContentList = new ArrayList<>();
        for (NewsContentEntity contentEntity : entityList) {
            NewsContentVO newsContentVO = new NewsContentVO();
            newsContentVO.setNewsContentID(contentEntity.getNewsContentID());
            newsContentVO.setNewsID(contentEntity.getNewsID());
            newsContentVO.setNewsContentType(contentEntity.getNewsContentType());
            newsContentVO.setNewsContent(contentEntity.getNewsContent());
            newsContentVO.setInDate(contentEntity.getInDate());
            newsContentVO.setInUser(contentEntity.getInUser());
            newsContentVO.setLastEditDate(contentEntity.getLastEditDate());
            newsContentVO.setLastEditUser(contentEntity.getLastEditUser());
            newsContentList.add(newsContentVO);
        }
        return newsContentList;
    }
}
