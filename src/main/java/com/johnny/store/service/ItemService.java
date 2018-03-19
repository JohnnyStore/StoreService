package com.johnny.store.service;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.UnifiedResponse;

public interface ItemService extends BaseService {
    UnifiedResponse find(String itemCode);

    UnifiedResponse findSalesList(int pageNumber, int pageSize, int brandID, int categoryID, int subCategoryID);

    UnifiedResponse changeItemToShowInList(ItemDTO itemDTO);
}
