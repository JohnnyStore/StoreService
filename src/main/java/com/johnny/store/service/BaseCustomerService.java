package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface BaseCustomerService<T> {
    UnifiedResponse findList(int pageNumber, int pageSize);

    UnifiedResponse find(int id);

    UnifiedResponse change(T dto);

}
