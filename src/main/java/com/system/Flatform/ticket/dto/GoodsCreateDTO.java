package com.system.Flatform.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 공연 티켓 등록(저장) DTO
 */
@Getter
public class GoodsCreateDTO {

    private String ticketName;
    private String period;
    private String address;
    private String genre;
    private int runningTime;
    private AgeToWatch ageToWatch;
    private int ticketPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asis/Seoul")
    private LocalDateTime showTime;
    private String ticketInformation;

    public Ticket toEntity() {
        return Ticket.builder()
                .ticketName(ticketName)
                .period(period)
                .address(address)
                .genre(genre)
                .runningTime(runningTime)
                .ageToWatch(ageToWatch)
                .ticketPrice(ticketPrice)
                .showTime(showTime)
                .ticketInformation(ticketInformation)
                .build();
    }
}
