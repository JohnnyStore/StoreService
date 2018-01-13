package com.johnny.store.mapper;

import com.johnny.store.entity.ExpressCompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ExpressCompanyMapper {

    int searchTotalCount();

    List<ExpressCompanyEntity> searchList(int startIndex, int pageSize);

    ExpressCompanyEntity search(int companyID);

    ExpressCompanyEntity searchByName(String companyName);

    int insert(ExpressCompanyEntity entity);

    int update(ExpressCompanyEntity entity);

    int delete(int companyID);
}
