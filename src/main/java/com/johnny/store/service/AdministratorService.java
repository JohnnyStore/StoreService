package com.johnny.store.service;

import com.johnny.store.dto.AdministratorDTO;
import com.johnny.store.dto.UnifiedResponse;

/**
 * 管理员信息业务接口
 */
public interface AdministratorService extends BaseService {
    UnifiedResponse checkAccountIsExists(String account);

    UnifiedResponse checkCellphoneIsExists(String cellphone);

    UnifiedResponse checkEmailIsExists(String email);

    UnifiedResponse login(String userName, String password);

    UnifiedResponse approve(AdministratorDTO dto);
}
