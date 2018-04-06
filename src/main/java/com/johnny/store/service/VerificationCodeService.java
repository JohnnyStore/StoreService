package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface VerificationCodeService extends BaseService {
    UnifiedResponse find(String cellphone, String verificationCode);
}
