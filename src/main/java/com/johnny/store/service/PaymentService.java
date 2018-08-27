package com.johnny.store.service;

import com.johnny.store.dto.PaymentDTO;
import com.johnny.store.dto.UnifiedResponse;

public interface PaymentService {
    String payment(PaymentDTO dto);
}
