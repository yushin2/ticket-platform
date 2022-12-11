package com.system.Flatform.category.service.impl;

import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.repository.CategoryRepository;
import com.system.Flatform.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    @Override
    public void saveCategory(CategorySaveDTO categorySaveDTO) {
        Category savedCategory = categoryRepository.save(categorySaveDTO.toEntity());

//        List<Long> twoDepthCategoryIds = categoryRepository.saveCategory(categorySaveDTO);
//        Category category = categoryRepository.findById(twoDepthCategoryIds.size() - 1L).orElseThrow();
//        savedCategory.setCategoryOrder(category.getCategoryOrder());

        if (savedCategory.getCategoryParentId() == null) {
            savedCategory.setCategoryParentId(savedCategory.getCategoryId());
            savedCategory.setCategoryOrder(1);
        }

        List<Category> categoryList = categoryRepository.getCategory(categorySaveDTO.getCategoryParentId());
        if (categoryList.size() == 1) savedCategory.setCategoryOrder(1);
//        else if (categoryList.size() > 1)
        /** 카테고리 order 관련 개발 진행 중 */

    }
}
