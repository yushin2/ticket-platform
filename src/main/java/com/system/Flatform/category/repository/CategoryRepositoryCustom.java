package com.system.Flatform.category.repository;

import java.util.List;

public interface CategoryRepositoryCustom {

    // 대분류 order 저장을 위한 대분류 count 구하기
    int getCategoryParentCount();
    int getCategoryChildCount(Long categoryParentId);
}
