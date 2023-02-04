package com.system.Flatform.goods.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GoodsReplyDetailDTO {

    private Long ticketReplyId;
    private String content;
    private int replyDepth;
    private Long replyParentId;

    @QueryProjection
    public GoodsReplyDetailDTO(Long ticketReplyId, String content, int replyDepth, Long replyParentId) {
        this.ticketReplyId = ticketReplyId;
        this.content = content;
        this.replyDepth = replyDepth;
        this.replyParentId = replyParentId;
    }
}
