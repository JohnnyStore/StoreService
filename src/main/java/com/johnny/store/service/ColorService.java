package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ColorService extends BaseService{
    UnifiedResponse findList(int itemID);
}
