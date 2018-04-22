package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface CityService extends BaseService {
    UnifiedResponse find(int cityID, int provinceID);
}
