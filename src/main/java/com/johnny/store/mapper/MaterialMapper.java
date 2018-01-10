package com.johnny.store.mapper;

import com.johnny.store.entity.MaterialEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MaterialMapper {
    int searchTotalCount();

    List<MaterialEntity> searchList(int startIndex, int pageMaterial);

    MaterialEntity search(int materialID);

    MaterialEntity searchByName(String materialName);

    int insert(MaterialEntity entity);

    int update(MaterialEntity entity);

    int delete(int materialID);
}
