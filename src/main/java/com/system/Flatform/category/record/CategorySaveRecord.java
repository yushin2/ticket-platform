package com.system.Flatform.category.record;

import com.system.Flatform.category.domain.Category;

/**
 * 카테고리 저장 record
 */
public record CategorySaveRecord(

        Long categoryParentId,
        String categoryName
) {
    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .categoryDepth((categoryParentId != null) ? 2 : 1) // 카테고리 id가 없으면 대분류 저장
                .categoryParentId((categoryParentId != null) ? categoryParentId : 0) // 카테고리 id가 있으면 중분류 저장이니까 그 id를 부모id로 저장
                .build();
    }


}