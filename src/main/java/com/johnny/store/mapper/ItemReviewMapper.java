package com.johnny.store.mapper;

import com.johnny.store.entity.ItemReviewEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 13425 on 2018/1/31.
 */
@Mapper
public interface ItemReviewMapper {
    int searchTotalCount(int customerID,String itemCode,String reviewLevel,String reviewStatus);

    List<ItemReviewEntity> searchList(int startIndex, int pageSize,int customerID, String itemCode, String reviewLevel, String reviewStatus);

    int insert(ItemReviewEntity entity);

    int update(ItemReviewEntity entity);

    int delete(int reviewID);
}
