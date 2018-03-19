package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface SizeService extends BaseService{
    UnifiedResponse findList(int itemID);
}
