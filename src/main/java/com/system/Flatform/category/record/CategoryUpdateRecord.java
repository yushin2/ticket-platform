package com.system.Flatform.category.record;

/**
 * 카테고리 수정 record
 */
public record CategoryUpdateRecord(
        Long categoryId,
        String categoryName
) {
}
