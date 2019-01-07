package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface CollectionService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String status);

    UnifiedResponse findListByItem(int customerID, int itemID, String status);
}
