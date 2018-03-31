package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

/**
 * ShoppingCartService
 *
 * @author liqian
 * @version 1.0.0
 * @since 1.0.0+
 */
public interface ShoppingCartService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, int customerID, String status);

    UnifiedResponse findList4Customer(int customerID);
}
