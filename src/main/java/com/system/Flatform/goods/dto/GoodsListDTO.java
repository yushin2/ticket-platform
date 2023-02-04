package com.system.Flatform.goods.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

/**
 * 티켓 상세 목록 DTO
 */
@Getter
public class GoodsListDTO {

    private Long ticketId;
    private String ticketName;
    private String address;
    private String period;

    @QueryProjection
    public GoodsListDTO(Long ticketId, String ticketName, String address, String period) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.address = address;
        this.period = period;
    }
}
