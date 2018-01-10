package com.johnny.store.mapper;

import com.johnny.store.entity.CityEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CityMapper {

    int searchTotalCount();

    List<CityEntity> searchList(int startIndex, int pageSize);

    CityEntity search(int cityID);

    CityEntity searchByName(String cityName);

    int insert(CityEntity entity);

    int update(CityEntity entity);

    int delete(int cityID);
}
