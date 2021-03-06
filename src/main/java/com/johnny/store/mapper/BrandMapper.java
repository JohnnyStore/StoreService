package com.johnny.store.mapper;
import com.johnny.store.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BrandMapper {

    int searchTotalCount();

    List<BrandEntity> searchList(int startIndex, int pageSize);

    BrandEntity search(int brandID);

    BrandEntity searchByName(String brandName);

    int insert(BrandEntity entity);

    int update(BrandEntity entity);

    int delete(int brandID);
}
