package com.johnny.store.mapper;

import com.johnny.store.entity.OrderEntity;
//import com.johnny.store.entity.OrderHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int searchTotalCount(String cellphone, String beginDate, String orderStatus);

    List<OrderEntity> searchList(int pageNumber, int pageSize, String cellphone, String beginDate, String orderStatus);

    List<OrderEntity> searchList4Customer(int pageNumber, int pageSize, int customerID, String orderStatus, String beginDate);

    List<OrderEntity> searchList4CustomerReview(int pageNumber, int pageSize, int customerID, String beginDate);

    int searchHistoryListTotalCount(int customerID, String orderStatus, String beginDate);

    int searchReviewOrderTotalCount(int customerID);

    OrderEntity search(int orderID);

    int insert(OrderEntity entity);

    int update(OrderEntity entity);

    int updateStatus(OrderEntity entity);

    int updateTrackingInfo(OrderEntity entity);

    int delete(int colorID);
}
