package com.system.Flatform.category.service.impl;

import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.record.CategorySaveRecord;
import com.system.Flatform.category.record.CategoryUpdateRecord;
import com.system.Flatform.category.repository.CategoryRepository;
import com.system.Flatform.category.service.CategoryService;
import com.system.Flatform.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 저장 ( 부모 카테고리 id 유무에 따라 대분류, 중분류 저장으로 분기 처리)
     * @param categorySaveRecord
     */
    @Transactional
    @Override
    public void saveCategory(CategorySaveRecord categorySaveRecord) {

        Category savedCategory = categoryRepository.save(categorySaveRecord.toEntity());

        // 대분류 카테고리 저장
        if (categorySaveRecord.categoryParentId() == null) {
            savedCategory.setCategoryParentId(savedCategory.getCategoryId());
            savedCategory.setCategoryOrder(categoryRepository.getCategoryParentCount());
        }
        else { // 중분류 카테고리 저장
            savedCategory.setCategoryOrder(categoryRepository.getCategoryChildCount(categorySaveRecord.categoryParentId()));
        }
    }

    @Transactional
    @Override
    public void updateCategory(CategoryUpdateRecord categoryUpdateRecord) {
        Category category = categoryRepository.findById(categoryUpdateRecord.categoryId()).orElseThrow(()
                -> new IllegalArgumentException(Constants.NO_GOODS_INFO_MSG));
        category.updateCategory(categoryUpdateRecord);

    }
}
