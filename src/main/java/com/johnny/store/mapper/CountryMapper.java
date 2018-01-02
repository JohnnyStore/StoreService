package com.johnny.store.mapper;

import com.johnny.store.entity.CountryEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CountryMapper {

    int searchTotalCount();

    List<CountryEntity> searchList(int startIndex, int pageSize);

    List<CountryEntity> searchAll();

    CountryEntity search(int countryID);

    CountryEntity searchByName(String countryName);

    int insert(CountryEntity entity);

    int update(CountryEntity entity);

    int delete(int countryID);
}
