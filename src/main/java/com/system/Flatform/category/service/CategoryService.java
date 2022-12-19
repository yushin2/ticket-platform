package com.system.Flatform.category.service;

import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.dto.CategoryUpdateDTO;

public interface CategoryService {

    void saveCategory(CategorySaveDTO categorySaveDTO);

    void updateCategory(CategoryUpdateDTO categoryUpdateDTO);
}
