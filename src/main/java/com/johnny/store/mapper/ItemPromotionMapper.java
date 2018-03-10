package com.johnny.store.mapper;

import com.johnny.store.entity.ItemPromotionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemPromotionMapper {
    int searchTotalCount(int itemID, String startDate, String endDate, String status);

    List<ItemPromotionEntity> searchList(int startIndex, int pageSize, int itemID, String startDate, String endDate, String status);

    List<ItemPromotionEntity> searchList4Category(int categoryID, String startDate, String endDate);

    int insert(ItemPromotionEntity entity);

    int update(ItemPromotionEntity entity);

    int delete(int itemPromotionID);
}
