package com.system.Flatform.ticket.dto;

import com.system.Flatform.ticket.domain.TicketReply;
import lombok.Getter;

/**
 * 공연 티켓 답글 등록(저장) DTO
 */
@Getter
public class TicketReplyCreateDTO {

    private String content;

    public TicketReply toEntity() {
        return TicketReply.builder()
                .content(content)
                .build();
    }
}
