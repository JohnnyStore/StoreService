package com.johnny.store.mapper;

import com.johnny.store.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int searchTotalCount();

    List<CustomerEntity> searchList(int startIndex, int pageSize);

    List<CustomerEntity> searchAll();

    CustomerEntity search(int customerID);

    int update(CustomerEntity entity);


}
