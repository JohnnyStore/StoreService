package com.johnny.store.service;

import com.johnny.store.common.StoreException;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.OrderEntity;
import com.johnny.store.vo.OrderVO;

import java.util.List;

public interface OrderService extends BaseService {
    UnifiedResponse findList(int startIndex, int pageSize, String customerTel, int recentMonth, String orderStatus);

    List<OrderVO> buildOrderVOList(List<OrderEntity> orderEntityList) throws StoreException;

    UnifiedResponse changeOrderStatus(Object dto);

    UnifiedResponse updateTrackingInfo(Object dto);
}
