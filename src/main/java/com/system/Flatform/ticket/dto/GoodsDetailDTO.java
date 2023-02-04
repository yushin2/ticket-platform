package com.system.Flatform.ticket.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.Getter;

import java.util.List;


/**
 * 티켓 상세 조회 DTO
 */
@Getter
public class GoodsDetailDTO {

    private Long ticketId;
    private String ticketName;
    private String period;
    private String address;
    private int runningTime;
    private String genre;
    private int ticketPrice;
    private AgeToWatch ageToWatch;
    private String ticketInformation;

    private List<TicketReplyDetailDTO> ticketReplyList;

    public void setTicketReplyList(List<TicketReplyDetailDTO> ticketReplyList) {
        this.ticketReplyList = ticketReplyList;
    }

    @QueryProjection
    public GoodsDetailDTO(Long ticketId, String ticketName, String period, String address, int runningTime, String genre, int ticketPrice, AgeToWatch ageToWatch, String ticketInformation) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.period = period;
        this.address = address;
        this.runningTime = runningTime;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
        this.ageToWatch = ageToWatch;
        this.ticketInformation = ticketInformation;
    }
}
