package com.johnny.store.mapper;

import com.johnny.store.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品一级分类 Mapper
 * @Author liqian
 */
@Mapper
public interface CategoryMapper {
    int searchTotalCount();

    List<CategoryEntity> searchList(int startIndex, int pageSize);

    CategoryEntity search(int categoryID);

    CategoryEntity searchByName(String categoryName);

    int insert(CategoryEntity entity);

    int update(CategoryEntity entity);

    int delete(int categoryID);
}
