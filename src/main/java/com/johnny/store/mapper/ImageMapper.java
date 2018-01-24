package com.johnny.store.mapper;
import com.johnny.store.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ImageMapper {
    List<ImageEntity> searchList(int objectID, String objectType, String imageType);

    List<ImageEntity> searchList4Item(int objectID, String objectType);

    int insert(ImageEntity entity);

    int update(ImageEntity entity);

    int delete(int objectID, String objectType, int groupID, String imageType);

    int deleteItemImage(int itemID, String objectType);
}
