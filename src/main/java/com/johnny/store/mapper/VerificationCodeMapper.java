package com.johnny.store.mapper;

import com.johnny.store.entity.VerificationCodeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationCodeMapper {
    VerificationCodeEntity search(String cellphone, String verificationCode);

    int insert(VerificationCodeEntity entity);
}
