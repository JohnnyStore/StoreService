package com.johnny.store.mapper;
import com.johnny.store.entity.ItemEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemMapper {
    int searchTotalCount();

    List<ItemEntity> searchList(int startIndex, int pageSize);

    int searchSalesCount(int brandID, int categoryID, int subCategoryID);

    List<ItemEntity> searchSalesList(int startIndex, int pageSize, int brandID, int categoryID, int subCategoryID);

    List<ItemEntity> searchListByItemName(int startIndex, int pageSize, String itemName);

    ItemEntity search(int itemID);

    ItemEntity searchByParameters(int brandID, int categoryID, int subCategoryID, int itemGroupID, int seriesID, int colorID, int sizeID);

    ItemEntity searchByItemCode(String itemCode);

    ItemEntity searchByItemName(int brandID, int categoryID, int subCategoryID, int seriesID, String itemName);

    int insert(ItemEntity entity);

    int update(ItemEntity entity);

    int updateItemToShowInList(ItemEntity entity);

    int delete(int brandID);
}
