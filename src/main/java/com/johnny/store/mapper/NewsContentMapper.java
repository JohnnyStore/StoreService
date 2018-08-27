package com.johnny.store.mapper;

import com.johnny.store.entity.NewsContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsContentMapper {
    List<NewsContentEntity> searchList4News(int newsID);

    int insert(NewsContentEntity entity);

    int update(NewsContentEntity entity);

    int delete(int id);
}
