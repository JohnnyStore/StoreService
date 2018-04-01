package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface CustomerService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, String status);

    UnifiedResponse login(String userName, String password);
}
