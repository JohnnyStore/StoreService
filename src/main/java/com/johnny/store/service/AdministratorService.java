package com.johnny.store.service;

import com.johnny.store.dto.AdministratorDTO;
import com.johnny.store.dto.UnifiedResponse;

public interface AdministratorService extends BaseService {
    UnifiedResponse checkAccountIsExists(String account);

    UnifiedResponse checkCellphoneIsExists(String cellphone);

    UnifiedResponse checkEmailIsExists(String email);

    UnifiedResponse login(String userName, String password);

    UnifiedResponse approve(AdministratorDTO dto);
}
