package com.system.Flatform.ticket.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class TicketReplyDetailDTO {

    private Long ticketReplyId;
    private String content;
    private int replyDepth;
    private Long replyParentId;

    @QueryProjection
    public TicketReplyDetailDTO(Long ticketReplyId, String content, int replyDepth, Long replyParentId) {
        this.ticketReplyId = ticketReplyId;
        this.content = content;
        this.replyDepth = replyDepth;
        this.replyParentId = replyParentId;
    }
}
