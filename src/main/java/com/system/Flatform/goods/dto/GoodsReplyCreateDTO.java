package com.system.Flatform.goods.dto;

import com.system.Flatform.goods.domain.Goods;
import com.system.Flatform.goods.domain.GoodsReply;
import lombok.Getter;

/**
 * 공연 티켓 답글 등록(저장) DTO
 */
@Getter
public class GoodsReplyCreateDTO {

    private Long ticketId;
    private String content;

    public GoodsReply toEntity(Goods goods) {
        return GoodsReply.builder()
                .content(content)
                .replyDepth((goods.getGoodsReplyList().size() == 0) ? 1 : 2)
                .goods(goods)
                .build();
    }
}
