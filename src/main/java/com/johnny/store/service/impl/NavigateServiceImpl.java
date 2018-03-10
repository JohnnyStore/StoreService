package com.johnny.store.service.impl;

import com.johnny.store.common.ConvertObjectUtils;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.StoreException;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.BrandEntity;
import com.johnny.store.entity.CategoryEntity;
import com.johnny.store.entity.SubCategoryEntity;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.BrandMapper;
import com.johnny.store.mapper.CategoryMapper;
import com.johnny.store.mapper.ImageMapper;
import com.johnny.store.mapper.SubCategoryMapper;
import com.johnny.store.service.NavigateService;
import com.johnny.store.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigateServiceImpl implements NavigateService {
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public UnifiedResponse find() {
        try{
            int startIndex = 0;
            int pageSize = 9999;
            NavigateVO navigateVO = new NavigateVO();
            List<BrandVO> brandVOList = new ArrayList<>();
            List<Navigate4CategoryVO> navigate4CategoryVOList = new ArrayList<>();

            List<BrandEntity> brandEntityList =  brandMapper.searchList(startIndex, pageSize);
            if(brandEntityList != null){
                for (BrandEntity brandEntity : brandEntityList) {
                    BrandVO brandVO = new BrandVO();
                    ConvertObjectUtils.convertJavaBean(brandVO, brandEntity);
                    brandVO.setBrandID(brandEntity.getBrandID());
                    brandVO.setImageID(brandEntity.getImageID());
                    brandVOList.add(brandVO);
                }
                navigateVO.setBrandList(brandVOList);
            }

            List<CategoryEntity> categoryEntityList =  categoryMapper.searchList(startIndex, pageSize);
            if(categoryEntityList != null){
                for (CategoryEntity categoryEntity : categoryEntityList) {
                    Navigate4CategoryVO navigate4CategoryVO = new Navigate4CategoryVO();
                    List<SubCategoryVO> subCategoryVOList = new ArrayList<>();
                    CategoryVO categoryVO = new CategoryVO();
                    ConvertObjectUtils.convertJavaBean(categoryVO, categoryEntity);
                    categoryVO.setCategoryID(categoryEntity.getCategoryID());

                    navigate4CategoryVO.setCategoryVO(categoryVO);

                    List<SubCategoryEntity> subCategoryEntityList = subCategoryMapper.searchByCategory(categoryEntity.getCategoryID());
                    if(subCategoryEntityList != null){
                        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
                            SubCategoryVO subCategoryVO = new SubCategoryVO();
                            ConvertObjectUtils.convertJavaBean(subCategoryVO, subCategoryEntity);
                            subCategoryVO.setSubCategoryID(subCategoryEntity.getSubCategoryID());
                            subCategoryVOList.add(subCategoryVO);
                        }
                        navigate4CategoryVO.setSubCategoryVOList(subCategoryVOList);
                    }
                    navigate4CategoryVOList.add(navigate4CategoryVO);
                }
                navigateVO.setNavigateCategoryList(navigate4CategoryVOList);
            }
            return UnifiedResponseManager.buildSuccessResponse(1, navigateVO);
        }catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }
}
