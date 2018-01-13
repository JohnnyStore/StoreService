package com.johnny.store.mapper;

import com.johnny.store.entity.SubCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  商品二级分类Mapper
 *  @Author liqian
 */
@Mapper
public interface SubCategoryMapper {
    int searchTotalCount();

    List<SubCategoryEntity> searchList(int startIndex, int pageSize);

    SubCategoryEntity search(int subCategoryID);

    SubCategoryEntity searchByName(String subCategoryName);

    int insert(SubCategoryEntity entity);

    int update(SubCategoryEntity entity);

    int delete(int subCategoryID);
}
