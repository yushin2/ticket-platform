package com.system.Flatform.category.service;

import com.system.Flatform.category.record.CategorySaveRecord;
import com.system.Flatform.category.record.CategoryUpdateRecord;

public interface CategoryService {

    void saveCategory(CategorySaveRecord categorySaveRecord);

    void updateCategory(CategoryUpdateRecord categoryUpdateRecord);
}
