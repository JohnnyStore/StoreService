package com.johnny.store.mapper;


import com.johnny.store.entity.ColorEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ColorMapper {

    int searchTotalCount();

    List<ColorEntity> searchList(int startIndex, int pageSize);

    ColorEntity search(int colorID);

    ColorEntity searchByName(String colorName);

    int insert(ColorEntity entity);

    int update(ColorEntity entity);

    int delete(int colorID);
}
