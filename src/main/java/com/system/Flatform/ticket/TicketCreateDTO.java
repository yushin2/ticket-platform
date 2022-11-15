package com.system.Flatform.ticket;

import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.Getter;

import java.time.LocalTime;


/**
 * 공연 티켓 생성(저장) DTO
 */
@Getter
public class TicketCreateDTO {

    private String ticketName;
    private String period;
    private String address;
    private String genre;
    private int runningTime;
    private AgeToWatch ageToWatch;
    private int ticketPrice;
    private LocalTime showTime;
    private String synopsis;

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
                .synopsis(synopsis)
                .build();
    }



}
