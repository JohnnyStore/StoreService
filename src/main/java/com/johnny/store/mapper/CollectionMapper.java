package com.johnny.store.mapper;

import com.johnny.store.entity.CollectionEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CollectionMapper{
    List<CollectionEntity> searchList(int startIndex, int pageSize, int customerID, String status);

    List<CollectionEntity> searchByItem(int customerID, int itemID, String status);

    int insert(CollectionEntity entity);

    int update(CollectionEntity entity);

    int delete(int cityID);
}
