package com.system.Flatform.ticket.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

/**
 * 티켓 상세 목록 DTO
 */
@Getter
public class TicketListDTO {

    private Long ticketId;
    private String ticketName;
    private String address;
    private String period;

    @QueryProjection
    public TicketListDTO(Long ticketId, String ticketName, String address, String period) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.address = address;
        this.period = period;
    }
}
