package com.johnny.store.mapper;
import com.johnny.store.entity.AdministratorEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 管理员信息Mapper层
 */
@Mapper
public interface AdministratorMapper {
    int searchTotalCount();

    List<AdministratorEntity> searchList(int startIndex, int pageSize);

    AdministratorEntity search(int administratorID);

    AdministratorEntity searchByName(String administratorName);

    int searchTotalCount4Account(String account);

    int searchTotalCount4Cellphone(String cellphone);

    int searchTotalCount4Email(String email);

    AdministratorEntity search4Login(String userName, String password);

    int insert(AdministratorEntity entity);

    int update(AdministratorEntity entity);

    int approve(AdministratorEntity entity);

    int delete(int administratorID);
}
