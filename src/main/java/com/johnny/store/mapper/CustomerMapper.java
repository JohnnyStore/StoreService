package com.johnny.store.mapper;

import com.johnny.store.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int searchTotalCount();

    List<CustomerEntity> searchList(int startIndex, int pageSize, String cellphone, String status);

    CustomerEntity search(int customerID);

    CustomerEntity searchByAccount(String account);

    CustomerEntity searchByCellphone(String cellphone);

    CustomerEntity searchByEmail(String email);

    CustomerEntity login(String userName, String password);

    int insert(CustomerEntity entity);

    int updateStatus(CustomerEntity entity);

    int changePassword(CustomerEntity entity);

    int update(CustomerEntity entity);

    int updatePassword(CustomerEntity entity);

    int delete(int customerID);
}
