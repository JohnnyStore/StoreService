package com.johnny.store.mapper;

import com.johnny.store.entity.ShippingAddressEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShippingAddressMapper {
    int searchTotalCount();

    List<ShippingAddressEntity> searchList(int startIndex, int pageSize);

    ShippingAddressEntity search(int shippingID);

    int insert(ShippingAddressEntity entity);

    int update(ShippingAddressEntity entity);

    int delete(int colorID);
}
