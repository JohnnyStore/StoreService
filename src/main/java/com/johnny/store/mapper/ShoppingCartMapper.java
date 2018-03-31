package com.johnny.store.mapper;

import com.johnny.store.entity.BrandHotEntity;
import com.johnny.store.entity.ShoppingCartEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ShoppingCartMapper
 *
 * @author liqian
 * @version 1.0.0
 * @since 1.0.0+
 */
@Mapper
public interface ShoppingCartMapper {
    int searchTotalCount(int customerID, String status);

    List<ShoppingCartEntity> searchList(int startIndex, int pageSize, int customerID, String status);

    List<ShoppingCartEntity> searchList4Customer(int customerID);

    int insert(ShoppingCartEntity entity);

    int update(ShoppingCartEntity entity);

    int delete(int shoppingCartID);
}
