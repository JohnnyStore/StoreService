package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface BaseService<T> {
    UnifiedResponse findList(int pageNumber, int pageSize);

    UnifiedResponse find(int id);

    UnifiedResponse existCheck(String name);

    UnifiedResponse add(T dto);

    UnifiedResponse change(T dto);

    UnifiedResponse delete(int id);
}