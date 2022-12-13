package com.system.Flatform.category.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.system.Flatform.category.domain.Category;
import com.system.Flatform.category.repository.CategoryRepositoryCustom;
import com.system.Flatform.utils.enums.DelYn;
import com.system.Flatform.utils.enums.UseYn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import static com.system.Flatform.category.domain.QCategory.category;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    @Override
    public int getCategoryParentCount() {
        return queryFactory.select(category.count())
                .from(category)
                .where(category.useYn.eq(UseYn.Y),
                        category.delYn.eq(DelYn.N),
                        category.categoryDepth.eq(1))
                .fetchOne().intValue();
    }

    @Transactional(readOnly = true)
    @Override
    public int getCategoryChildCount(Long categoryParentId) {
        return queryFactory.select(category.count())
                .from(category)
                .where(category.useYn.eq(UseYn.Y),
                        category.delYn.eq(DelYn.N),
                        category.categoryDepth.eq(2),
                        category.categoryParentId.eq(categoryParentId))
                .fetchOne().intValue();
    }
}
