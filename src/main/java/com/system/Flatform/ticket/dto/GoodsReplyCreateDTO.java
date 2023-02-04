package com.system.Flatform.ticket.dto;

import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.ticket.domain.TicketReply;
import lombok.Getter;

/**
 * 공연 티켓 답글 등록(저장) DTO
 */
@Getter
public class GoodsReplyCreateDTO {

    private Long ticketId;
    private String content;

    public TicketReply toEntity(Ticket ticket) {
        return TicketReply.builder()
                .content(content)
                .replyDepth((ticket.getTicketReplyList().size() == 0) ? 1 : 2)
                .ticket(ticket)
                .build();
    }
}
