package com.johnny.store.mapper;

import com.johnny.store.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    int searchTotalCount();

    List<NewsEntity> searchList(int startIndex, int pageSize);

    NewsEntity search(int id);

    int insert(NewsEntity entity);

    int update(NewsEntity entity);

    int delete(int id);
}
