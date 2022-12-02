package com.system.Flatform.category.service.impl;

import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.repository.CategoryRepository;
import com.system.Flatform.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    @Override
    public void saveCategory(CategorySaveDTO categorySaveDTO) {
        Category savedCategory = categoryRepository.save(categorySaveDTO.toEntity());
        /** 카테고리 뎁스, order 구현 어떻게 하지? */


    }
}
