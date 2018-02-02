package com.johnny.store.mapper;

import com.johnny.store.entity.WholesalerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WholesalerMapper {
    int searchTotalCount();

    List<WholesalerEntity> searchList(int startIndex, int pageSize, String cellphone, String status);

    WholesalerEntity search(int customerID);

    int insert(WholesalerEntity entity);

    int updateStatus(WholesalerEntity entity);

    int update(WholesalerEntity entity);

    int updatePassword(WholesalerEntity entity);

    int delete(int wholesalerID);
}
