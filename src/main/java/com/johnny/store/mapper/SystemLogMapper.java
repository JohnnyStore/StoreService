package com.johnny.store.mapper;
import com.johnny.store.entity.SystemLogEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SystemLogMapper {
    int searchTotalCount();

    List<SystemLogEntity> searchList(int startIndex, int pageSize);

    SystemLogEntity search(int logID);

    int insert(SystemLogEntity entity);

    int updateStatus(SystemLogEntity entity);
}
