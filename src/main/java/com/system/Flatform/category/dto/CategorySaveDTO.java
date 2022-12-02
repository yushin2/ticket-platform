package com.system.Flatform.category.dto;

import com.system.Flatform.category.domain.Category;
import lombok.Getter;

@Getter
public class CategorySaveDTO {

    private Long categoryId;
    private String categoryName;

    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .categoryDepth((categoryId != null) ? 2 : 1) // 카테고리 id가 없으면 대분류 저장
//                .categoryParentId((categoryId != null) ? categoryId : null)
                .build();
    }
}
