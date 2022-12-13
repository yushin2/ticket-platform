package com.system.Flatform.category.service.impl;

import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.dto.CategoryUpdateDTO;
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
     * @param categorySaveDTO
     */
    @Transactional
    @Override
    public void saveCategory(CategorySaveDTO categorySaveDTO) {

        Category savedCategory = categoryRepository.save(categorySaveDTO.toEntity());

        // 대분류 카테고리 저장
        if (categorySaveDTO.getCategoryParentId() == null) {
            savedCategory.setCategoryParentId(savedCategory.getCategoryId());
            savedCategory.setCategoryOrder(categoryRepository.getCategoryParentCount());
        }
        else { // 중분류 카테고리 저장
            savedCategory.setCategoryOrder(categoryRepository.getCategoryChildCount(categorySaveDTO.getCategoryParentId()));
        }
    }

    @Transactional
    @Override
    public void updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        Category category = categoryRepository.findById(categoryUpdateDTO.categoryId()).orElseThrow(()
                -> new IllegalArgumentException(Constants.NO_TICKET_INFO_MSG));
        category.updateCategory(categoryUpdateDTO);

    }
}
