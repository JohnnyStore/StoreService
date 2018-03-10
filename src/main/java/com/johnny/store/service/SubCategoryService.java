package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface SubCategoryService extends BaseService{
    UnifiedResponse findByCategory(int categoryID);
}
