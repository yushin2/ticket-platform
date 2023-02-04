package com.system.Flatform.goods.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 공연 가격 정보 도메인
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicUpdate
@Table(name = "goods_price")
public class GoodsPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_price_id")
    private Long goodsPriceId;

    @Column(name = "goods_price", columnDefinition = "INT(20) COMMENT '공연 가격'")
    private int goodsPrice;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public GoodsPrice(Long goodsPriceId, int goodsPrice, Goods goods) {
        this.goodsPriceId = goodsPriceId;
        this.goodsPrice = goodsPrice;
        this.goods = goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
        goods.getGoodsPriceList().add(this);
    }
}
