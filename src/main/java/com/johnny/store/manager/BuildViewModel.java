package com.johnny.store.manager;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.entity.MaterialEntity;
import com.johnny.store.mapper.MaterialMapper;
import com.johnny.store.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildViewModel {
    @Autowired
    private MaterialMapper materialMapper;

    public ItemVO buildItemViewModel(ItemEntity entity) throws StoreException {
        ItemVO model = null;
        if(entity != null){
            model = new ItemVO();
            String[] itemMaterialArray = entity.getItemMaterial().split(",");
            List<String> itemMaterialList = new ArrayList<>();
            for (String itemMaterialID : itemMaterialArray) {
                MaterialEntity materialEntity = materialMapper.search(Integer.parseInt(itemMaterialID));
                itemMaterialList.add(materialEntity.getMaterialCN());
            }
            ConvertObjectUtils.convertJavaBean(model, entity);
            model.setItemMaterialName(String.join(",", itemMaterialList));
            model.setItemID(entity.getItemID());
            model.setBrandID(entity.getBrandID());
            model.setCategoryID(entity.getCategoryID());
            model.setSubCategoryID(entity.getSubCategoryID());
            model.setItemGroupID(entity.getItemGroupID());
            model.setSeriesID(entity.getSeriesID());
            model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
            model.setPromotionPrice4RMB(entity.getPromotionPrice4RMB());
            model.setUnitPrice4USD(entity.getUnitPrice4USD());
            model.setPromotionPrice4USD(entity.getPromotionPrice4USD());
            model.setRate(entity.getRate());
            model.setColorID(entity.getColorID());
            model.setSizeID(entity.getSizeID());
            model.setMadeInID(entity.getMadeInID());
        }
        return model;
    }
}
