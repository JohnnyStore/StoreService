package com.johnny.store.mapper;
import com.johnny.store.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ImageMapper {
    List<ImageEntity> searchList(int objectID, String objectType, String mageType);

    int insert(ImageEntity entity);

    int update(ImageEntity entity);

    int delete(int brandID);
}
