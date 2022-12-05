package com.system.Flatform.category.repository;


import com.system.Flatform.category.domain.Category;

import java.util.List;

public interface CategoryRepositoryCustom {

    List<Category> getCategory(Long parentCategoryId);
}
