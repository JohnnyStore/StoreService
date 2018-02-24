package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface OrderTransactionService extends BaseService {
    UnifiedResponse findList(int orderID);
}
