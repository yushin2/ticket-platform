package com.system.Flatform.goods.domain;

import com.system.Flatform.goods.dto.GoodsReplyUpdateDTO;
import com.system.Flatform.utils.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 공연 답글 도메인
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "goods_reply")
public class GoodsReply extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "goods_reply_id")
    private Long goodsReplyId;

    @Column(name = "content", columnDefinition = "VARCHAR(255) COMMENT '답글 내용'")
    private String content;

    @Column(name = "reply_depth", columnDefinition = "INT(8) COMMENT '답글 DEPTH'")
    private int replyDepth;

    @Column(name = "reply_parent_id")
    private Long replyParentId;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public GoodsReply(String content, int replyDepth, Long replyParentId, Goods goods) {
        this.content = content;
        this.replyDepth = replyDepth;
        this.replyParentId = replyParentId;
        this.goods = goods;
    }

    public void setReplyParentId(Long replyParentId) {
        this.replyParentId = replyParentId;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
        goods.getGoodsReplyList().add(this);
    }

    public void updateReplyContent(GoodsReplyUpdateDTO goodsReplyUpdateDTO) {
        this.content = goodsReplyUpdateDTO.getContent();
    }


}
