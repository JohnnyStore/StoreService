package com.johnny.store.mapper;
import com.johnny.store.entity.BrandHotEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BrandHotMapper {
    int searchTotalCount();

    List<BrandHotEntity> searchList(int startIndex, int pageSize);

    BrandHotEntity search(int brandHotID);

    int insert(BrandHotEntity entity);

    int update(BrandHotEntity entity);

    int delete(int brandHotID);
}