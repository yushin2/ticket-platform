package com.system.Flatform.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketUpdateDTO {

    private Long ticketId;
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
}
