package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ItemPromotionService extends BaseService{
    UnifiedResponse findList(int pageNumber, int pageSize, int itemID, String startDate, String endDate, String status);

    UnifiedResponse findList(int categoryID, String startDate, String endDate);

    UnifiedResponse findCurrentList(int categoryID);
}
