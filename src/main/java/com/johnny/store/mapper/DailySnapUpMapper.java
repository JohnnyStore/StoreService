package com.johnny.store.mapper;

import com.johnny.store.entity.DailySnapUpEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DailySnapUpMapper {
    int searchTotalCount(String snapUpDate, String status);

    List<DailySnapUpEntity> searchList(int startIndex, int pageSize, String snapUpDate, String status);

    DailySnapUpEntity search(int snapUpID);

    List<DailySnapUpEntity> searchBySnapUpDate(String snapUpDate);

    List<DailySnapUpEntity> searchByItemID(int itemID, String snapUpDate);

    int insert(DailySnapUpEntity entity);

    int update(DailySnapUpEntity entity);

    int delete(int snapUpID);
}
