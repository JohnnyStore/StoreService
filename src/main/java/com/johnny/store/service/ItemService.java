package com.johnny.store.service;

import com.johnny.store.common.StoreException;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.vo.ItemVO;

public interface ItemService extends BaseService {
    UnifiedResponse find(String itemCode);

    ItemVO buildViewModel(ItemEntity entity) throws StoreException;
}
