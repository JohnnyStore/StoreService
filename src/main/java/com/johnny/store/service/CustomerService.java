package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.CustomerEntity;

public interface CustomerService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, String status);

    UnifiedResponse login(String userName, String password);

    UnifiedResponse findByAccount(String account);

    UnifiedResponse findByCellphone(String cellphone);

    UnifiedResponse findByEmail(String email);

    UnifiedResponse changePassword(Object dto);
}
