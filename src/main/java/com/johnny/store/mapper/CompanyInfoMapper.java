package com.johnny.store.mapper;

import com.johnny.store.entity.CompanyInfoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyInfoMapper {
    CompanyInfoEntity search(int infoID);

    int insert(CompanyInfoEntity entity);

    int update(CompanyInfoEntity entity);

    int delete(int infoID);
}
