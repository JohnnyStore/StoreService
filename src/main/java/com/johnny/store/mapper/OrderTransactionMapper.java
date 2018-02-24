package com.johnny.store.mapper;

import com.johnny.store.entity.OrderTransactionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderTransactionMapper {

    List<OrderTransactionEntity> searchList(int orderID);

    OrderTransactionEntity search(int orderTransactionID);

    int insert(OrderTransactionEntity entity);

    int delete(int orderTransactionID);
}
