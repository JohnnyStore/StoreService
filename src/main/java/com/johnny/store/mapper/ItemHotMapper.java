package com.johnny.store.mapper;
import com.johnny.store.entity.ItemHotEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ItemHotMapper {

    int searchTotalCount(int itemID, String startDate, String endDate, String status);

    List<ItemHotEntity> searchList(int startIndex, int pageSize, int itemID, String startDate, String endDate, String status);

    List<ItemHotEntity> searchCurrentList(String currentDate);

    ItemHotEntity search(int itemID);

    ItemHotEntity find(String itemCode);

    ItemHotEntity searchByName(String itemName);

    int insert(ItemHotEntity entity);

    int update(ItemHotEntity entity);

    int delete(int itemID);
}
