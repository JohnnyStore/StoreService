package com.johnny.store.manager;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.DateUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.entity.DailySnapUpEntity;
import com.johnny.store.entity.ItemEntity;
import com.johnny.store.entity.ItemPromotionEntity;
import com.johnny.store.entity.MaterialEntity;
import com.johnny.store.mapper.DailySnapUpMapper;
import com.johnny.store.mapper.ItemPromotionMapper;
import com.johnny.store.mapper.MaterialMapper;
import com.johnny.store.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildViewModel {

    @Autowired
    private DailySnapUpMapper dailySnapUpMapper;

    @Autowired
    private ItemPromotionMapper itemPromotionMapper;

    @Autowired
    private MaterialMapper materialMapper;

    public ItemVO buildItemViewModel(ItemEntity entity) throws StoreException {
        ItemVO model = null;
        if(entity != null){
            model = new ItemVO();
            String[] itemMaterialArray = entity.getItemMaterial().split(",");
            List<String> itemMaterialListCN = new ArrayList<>();
            List<String> itemMaterialListEN = new ArrayList<>();
            for (String itemMaterialID : itemMaterialArray) {
                MaterialEntity materialEntity = materialMapper.search(Integer.parseInt(itemMaterialID));
                itemMaterialListCN.add(materialEntity.getMaterialCN());
                itemMaterialListEN.add(materialEntity.getMaterialEN());
            }
            ConvertObjectUtils.convertJavaBean(model, entity);

            String currentDate = DateUtils.getCurrentDateTime().substring(0, 10);
            //取得该商品当天的促销价格
            List<ItemPromotionEntity> itemPromotionEntityList = itemPromotionMapper.searchList4Item(entity.getItemID(), currentDate);
            if(itemPromotionEntityList != null && itemPromotionEntityList.size() > 0){
                model.setPromotionPrice4RMB(Double.parseDouble(itemPromotionEntityList.get(0).getPromotionPrice4RMB()));
                model.setPromotionPrice4USD(Double.parseDouble(itemPromotionEntityList.get(0).getPromotionPrice4USD()));
            }
            //取得该商品的每日抢购价格
            List<DailySnapUpEntity> dailySnapUpEntityList = dailySnapUpMapper.searchByItemID(entity.getItemID(), currentDate);
            if(dailySnapUpEntityList != null && dailySnapUpEntityList.size() > 0){
                model.setSnapUpPrice4RMB(dailySnapUpEntityList.get(0).getSnapUpPrice4RMB());
                model.setSnapUpPrice4USD(dailySnapUpEntityList.get(0).getSnapUpPrice4USD());
            }

            model.setItemMaterialNameCN(String.join(",", itemMaterialListCN));
            model.setItemMaterialNameEN(String.join(",", itemMaterialListEN));
            model.setItemID(entity.getItemID());
            model.setBrandID(entity.getBrandID());
            model.setCategoryID(entity.getCategoryID());
            model.setSubCategoryID(entity.getSubCategoryID());
            model.setItemGroupID(entity.getItemGroupID());
            model.setSeriesID(entity.getSeriesID());
            model.setUnitPrice4RMB(entity.getUnitPrice4RMB());
            model.setUnitPrice4USD(entity.getUnitPrice4USD());
            model.setRate(entity.getRate());
            model.setColorID(entity.getColorID());
            model.setSizeID(entity.getSizeID());
            model.setMadeInID(entity.getMadeInID());

            //这是该商品是否有折扣
            if((model.getPromotionPrice4RMB() > 0 && model.getPromotionPrice4USD() > 0)
                    || (model.getSnapUpPrice4RMB() > 0 && model.getSnapUpPrice4USD() > 0)){
                model.setHasDiscount(true);
            }

            //设置该商品的销售价格
            if(model.getPromotionPrice4RMB() > 0 && model.getSnapUpPrice4RMB() > 0){
                model.setSalesPrice4RMB(model.getPromotionPrice4RMB() < model.getSnapUpPrice4RMB() ?
                        model.getPromotionPrice4RMB() : model.getSnapUpPrice4RMB());
            }else if(model.getPromotionPrice4RMB() > 0){
                model.setSalesPrice4RMB(model.getPromotionPrice4RMB());
            }else if(model.getSnapUpPrice4RMB() > 0){
                model.setSalesPrice4RMB(model.getSnapUpPrice4RMB());
            }else{
                model.setSalesPrice4RMB(model.getUnitPrice4RMB());
            }

            if(model.getPromotionPrice4USD() > 0 && model.getSnapUpPrice4USD() > 0){
                model.setSalesPrice4USD(model.getPromotionPrice4USD() < model.getSnapUpPrice4USD() ?
                        model.getPromotionPrice4USD() : model.getSnapUpPrice4USD());
            }else if(model.getPromotionPrice4USD() > 0){
                model.setSalesPrice4USD(model.getPromotionPrice4USD());
            }else if(model.getSnapUpPrice4USD() > 0){
                model.setSalesPrice4USD(model.getSnapUpPrice4USD());
            }else{
                model.setSalesPrice4USD(model.getUnitPrice4USD());
            }
        }
        return model;
    }
}
