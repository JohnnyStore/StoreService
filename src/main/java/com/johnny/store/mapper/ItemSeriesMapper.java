package com.johnny.store.mapper;

import com.johnny.store.entity.ItemSeriesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemSeriesMapper {
    int searchTotalCount();

    List<ItemSeriesEntity> searchList(int startIndex, int pageSize);

    List<ItemSeriesEntity> searchList4Item(int itemID);

    ItemSeriesEntity search(int seriesID);

    ItemSeriesEntity searchByName(String itemSeriesName);

    int insert(ItemSeriesEntity entity);

    int update(ItemSeriesEntity entity);

    int delete(int seriesID);
}
