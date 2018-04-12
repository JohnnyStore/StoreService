package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ThirdPartyAPIService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, String thirdParty, boolean result);
}
