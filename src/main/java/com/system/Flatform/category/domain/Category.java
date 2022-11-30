//package com.system.Flatform.category.domain;
//
//import com.system.Flatform.utils.BaseEntity;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;
//
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@DynamicUpdate
//@Entity
//@Table(name = "category")
//public class Category extends BaseEntity { todo : SqlException 발생으로 인한 임시 주석 처리
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "category_id")
//    private Long categoryId;
//
//    @Column(name = "category_name", columnDefinition = "VARCHAR(255) COMMENT '카테고리명'")
//    private String categoryName;
//
//    @Column(name = "depth", columnDefinition = "VARCHAR(255) COMMENT '카테고리 뎁스'")
//    private int depth;
//
//    @Column(name = "order", columnDefinition = "VARCHAR(255) COMMENT '카테고리 순서'")
//    private int order;
//
//    @Column(name = "parent_id")
//    private int parentId;
//
//    @Builder
//    public Category(Long categoryId, String categoryName, int depth, int order, int parentId) {
//        this.categoryId = categoryId;
//        this.categoryName = categoryName;
//        this.depth = depth;
//        this.order = order;
//        this.parentId = parentId;
//    }
//}
