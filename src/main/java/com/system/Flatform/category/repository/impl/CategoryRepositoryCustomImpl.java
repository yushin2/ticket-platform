package com.system.Flatform.category.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.dto.CategorySaveDTO;
import com.system.Flatform.category.repository.CategoryRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.system.Flatform.category.domain.QCategory.category;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getCategory(Long parentCategoryId) {

        List<Category> categories = queryFactory.select(category)
                .from(category)
                .where(category.categoryParentId.eq(parentCategoryId))
                .fetch();

        return categories;
    }

//    @Transactional
//    @Override
//    public List<Long> saveCategory(CategorySaveDTO categorySaveDTO) {
//
//        return queryFactory.select(category.categoryId)
//                .from(category)
//                .where(category.categoryDepth.eq(2),
//                        category.categoryParentId.eq(categorySaveDTO.getCategoryId()))
//                .fetch();

//        queryFactory.update(category)
//                .set(category.categoryOrder, twoDepthCategoryIds.size())
//                .where(category.categoryId)
//                .execute();
//    }
}
