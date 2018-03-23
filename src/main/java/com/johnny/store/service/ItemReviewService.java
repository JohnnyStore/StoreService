package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ItemReviewService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String itemCode, String reviewLevel, String reviewStatus);

    UnifiedResponse findList(int pageNumber, int pageSize, int itemID, String reviewLevel);
}
