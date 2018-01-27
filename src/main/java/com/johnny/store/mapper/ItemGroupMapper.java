package com.johnny.store.mapper;
import com.johnny.store.entity.ItemGroupEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemGroupMapper {
    int searchTotalCount();

    List<ItemGroupEntity> searchList(int startIndex, int pageSize);

    List<ItemGroupEntity> searchAll();

    List<ItemGroupEntity> searchItemGroupWithCondition(int brandID, int categoryID, int subCategoryID);

    ItemGroupEntity search(int itemGroupID);

    ItemGroupEntity searchByName(String itemGroupName);

    int insert(ItemGroupEntity entity);

    int update(ItemGroupEntity entity);

    int delete(int itemGroupID);
}
