package com.johnny.store.mapper;

import com.johnny.store.entity.ItemReviewEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 13425 on 2018/1/31.
 */
@Mapper
public interface ItemReviewMapper {
    int searchTotalCount();

    List<ItemReviewEntity> searchList(int startIndex, int pageSize);

    ItemReviewEntity search(int customerID, int itemID, String reviewLevel, String reviewStatus);

    ItemReviewEntity search(int reviewID);

    int insert(ItemReviewEntity entity);

    int update(ItemReviewEntity entity);

    int delete(int reviewID);
}
