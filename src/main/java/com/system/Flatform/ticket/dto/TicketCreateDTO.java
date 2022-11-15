package com.system.Flatform.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.ticket.domain.Ticket;
import com.system.Flatform.utils.DateTimeUtils;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

/**
 * 공연 티켓 등록(저장) DTO
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
    @DateTimeFormat(pattern = "HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "Asis/Seoul")
    private String showTime;
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
                .showTime(DateTimeUtils.stringToLocalTime(showTime))
                .ticketInformation(ticketInformation)
                .build();
    }
}
