package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ItemHotService extends BaseService{
    UnifiedResponse findList(int pageNumber, int pageSize, int itemID, String startDate, String endDate, String status);

    UnifiedResponse findCurrentList();
}
