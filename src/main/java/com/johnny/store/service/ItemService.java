package com.johnny.store.service;

import com.johnny.store.dto.ItemDTO;
import com.johnny.store.dto.UnifiedResponse;

public interface ItemService extends BaseService {
    UnifiedResponse find(String itemCode);

    UnifiedResponse find(int brandID, int categoryID, int subCategoryID, int itemGroupID, int seriesID, int colorID, int sizeID);

    UnifiedResponse findSalesList(int pageNumber, int pageSize, int brandID, int categoryID, int subCategoryID);

    UnifiedResponse changeItemToShowInList(ItemDTO itemDTO);
}
