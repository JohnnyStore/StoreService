package com.johnny.store.mapper;

import com.johnny.store.entity.ProvinceEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProvinceMapper {

    int searchTotalCount();

    List<ProvinceEntity> searchList(int startIndex, int pageSize);

    ProvinceEntity search(int provinceID);

    ProvinceEntity searchByName(String provinceName);

    int insert(ProvinceEntity entity);

    int update(ProvinceEntity entity);

    int delete(int provinceID);
}
