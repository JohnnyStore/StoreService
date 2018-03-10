package com.johnny.store.vo;

import java.util.List;

public class NavigateVO {
    private List<BrandVO> brandList;
    private List<Navigate4CategoryVO> navigateCategoryList;

    public List<BrandVO> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandVO> brandList) {
        this.brandList = brandList;
    }

    public List<Navigate4CategoryVO> getNavigateCategoryList() {
        return navigateCategoryList;
    }

    public void setNavigateCategoryList(List<Navigate4CategoryVO> navigateCategoryList) {
        this.navigateCategoryList = navigateCategoryList;
    }
}
