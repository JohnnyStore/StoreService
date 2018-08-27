package com.johnny.store.service;

import com.johnny.store.dto.CompanyInfoDTO;
import com.johnny.store.dto.UnifiedResponse;

public interface CompanyInfoService {
    UnifiedResponse find(int infoID);

    UnifiedResponse save(CompanyInfoDTO dto);
}
