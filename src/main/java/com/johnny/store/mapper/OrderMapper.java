package com.johnny.store.mapper;

import com.johnny.store.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int searchTotalCount(String cellphone, String beginDate, String orderStatus);

    List<OrderEntity> searchList(int pageNumber, int pageSize, String cellphone, String beginDate, String orderStatus);

    OrderEntity search(int orderID);

    int insert(OrderEntity entity);

    int update(OrderEntity entity);

    int updateStatus(OrderEntity entity);

    int updateTrackingInfo(OrderEntity entity);

    int delete(int colorID);
}
