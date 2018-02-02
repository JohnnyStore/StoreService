package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface WholesalerService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, String email, String status);
}
