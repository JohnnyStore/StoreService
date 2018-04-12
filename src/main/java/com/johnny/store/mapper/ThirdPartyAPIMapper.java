package com.johnny.store.mapper;

import com.johnny.store.entity.ThirdPartyAPIEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThirdPartyAPIMapper {
    List<ThirdPartyAPIEntity> searchList(int startIndex, int pageSize, String thirdPart, boolean result);

    int insert(ThirdPartyAPIEntity entity);
}
