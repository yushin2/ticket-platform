package com.system.Flatform.category.domain;

import com.system.Flatform.utils.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name",  columnDefinition = "VARCHAR(255) COMMENT '카테고리명'")
    private String categoryName;

    @Column(name = "category_depth", columnDefinition = "INT(11) COMMENT '카테고리 DEPTH'")
    private int categoryDepth;

    @Column(name = "category_order", columnDefinition = "INT(11) COMMENT '카테고리 순서'")
    private int categoryOrder;

    @Column(name = "category_parent_id")
    private Long categoryParentId;

    @Builder
    public Category(Long categoryId, String categoryName, int categoryDepth, int categoryOrder, Long categoryParentId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDepth = categoryDepth;
        this.categoryOrder = categoryOrder;
        this.categoryParentId = categoryParentId;
    }
}
