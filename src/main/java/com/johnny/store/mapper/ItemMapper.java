package com.johnny.store.mapper;
import com.johnny.store.entity.ItemEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemMapper {
    int searchTotalCount();

    List<ItemEntity> searchList(int startIndex, int pageSize);

    ItemEntity search(int itemID);

    ItemEntity searchByItemCode(String itemCode);

    ItemEntity searchByItemName(int brandID, int categoryID, int subCategoryID, int seriesID, String itemName);

    int insert(ItemEntity entity);

    int update(ItemEntity entity);

    int delete(int brandID);
}
