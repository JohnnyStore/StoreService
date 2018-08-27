package com.johnny.store.service;

import com.johnny.store.dto.NewsContentDTO;
import com.johnny.store.dto.NewsDTO;
import com.johnny.store.entity.NewsContentEntity;
import com.johnny.store.entity.NewsEntity;
import com.johnny.store.vo.NewsVO;

public interface NewsService extends BaseService {
    NewsContentEntity convertDtoToEntity(NewsContentDTO dto, int newsID);

    NewsVO convertEntityToVo(NewsEntity entity);

    NewsEntity convertDtoToEntity(NewsDTO dto);
}
