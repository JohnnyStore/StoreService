package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ItemSeriesService extends BaseService{
    UnifiedResponse findList(int itemID);
}
