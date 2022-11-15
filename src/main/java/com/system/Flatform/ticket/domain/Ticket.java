package com.system.Flatform.ticket.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.utils.BaseEntity;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 공연 티켓 도메인
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "ticket_name", columnDefinition = "VARCHAR(255) COMMENT '티켓명'")
    private String ticketName;

    @Column(name = "period", columnDefinition = "VARCHAR(255) COMMENT '공연기간'")
    private String period;

    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '공연장 주소'")
    private String address;

    @Column(name = "genre", columnDefinition = "VARCHAR(50) COMMENT '장르'")
    private String genre;

    @Column(name = "runningTime", columnDefinition = "INT(20) COMMENT '공연시간'")
    private int runningTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_to_watch", columnDefinition = "VARCHAR(50) COMMENT '시청 연령가'")
    private AgeToWatch ageToWatch;

    @Column(name = "ticket_price", columnDefinition = "INT(20) COMMENT '티켓 가격'")
    private int ticketPrice;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
//    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "show_time", columnDefinition = "DATETIME COMMENT '공연 시작 시간'")
    private LocalTime showTime;

    @Column(name = "ticket_information", columnDefinition = "VARCHAR(255) COMMENT '공연 정보'")
    private String ticketInformation;

    @OneToMany(mappedBy = "ticket")
    private List<TicketReply> ticketReplyList = new ArrayList<>();

    public void setTicketReplyList(List<TicketReply> ticketReplyList) {
        ticketReplyList.stream().forEach(ticketReply -> {
            ticketReply.setTicket(this);
        });
    }

    @Builder
    public Ticket(Long ticketId, String ticketName, String period, String address, String genre, int runningTime, AgeToWatch ageToWatch,
                  int ticketPrice, LocalTime showTime, String ticketInformation, List<TicketReply> ticketReplyList) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.period = period;
        this.address = address;
        this.genre = genre;
        this.runningTime = runningTime;
        this.ageToWatch = ageToWatch;
        this.ticketPrice = ticketPrice;
        this.showTime = showTime;
        this.ticketInformation = ticketInformation;
        this.ticketReplyList = ticketReplyList;
    }
}
