package com.johnny.store.mapper;
import com.johnny.store.entity.SystemLogEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SystemLogMapper {
    List<SystemLogEntity> searchLogList();

    SystemLogEntity searchLog(int logID);

    int insertLog(SystemLogEntity entity);

    int updateStatus(SystemLogEntity entity);
}
