package com.johnny.store.service;

import com.johnny.store.dto.UnifiedResponse;

public interface DailySnapUpService extends BaseService {
    UnifiedResponse findList(int pageNumber, int pageSize, String snapUpDate, String status);

    UnifiedResponse findCurrentDailySnapUp();

}
