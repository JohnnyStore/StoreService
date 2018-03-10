package com.johnny.store.vo;

import java.util.List;

public class Navigate4CategoryVO {
    private CategoryVO categoryVO;
    private List<SubCategoryVO> subCategoryVOList;

    public CategoryVO getCategoryVO() {
        return categoryVO;
    }

    public void setCategoryVO(CategoryVO categoryVO) {
        this.categoryVO = categoryVO;
    }

    public List<SubCategoryVO> getSubCategoryVOList() {
        return subCategoryVOList;
    }

    public void setSubCategoryVOList(List<SubCategoryVO> subCategoryVOList) {
        this.subCategoryVOList = subCategoryVOList;
    }
}
