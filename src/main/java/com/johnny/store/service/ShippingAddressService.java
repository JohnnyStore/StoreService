package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface ShippingAddressService extends BaseService {
    UnifiedResponse find4Customer(int customerID);

}
