package com.system.Flatform.ticket.domain;

import com.system.Flatform.ticket.dto.GoodsUpdateDTO;
import com.system.Flatform.utils.BaseEntity;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Long goodsId;

    @Column(name = "ticket_name", columnDefinition = "VARCHAR(255) COMMENT '티켓명'")
    private String goodsName;

    @Column(name = "period", columnDefinition = "VARCHAR(255) COMMENT '공연기간'")
    private String goodsPeriod;

    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '공연장 주소'")
    private String goodsAddress;

    @Column(name = "runningTime", columnDefinition = "INT(20) COMMENT '공연시간'")
    private int runningTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_to_watch", columnDefinition = "VARCHAR(50) COMMENT '시청 연령가'")
    private AgeToWatch ageToWatch;

    @Column(name = "show_time", columnDefinition = "DATETIME COMMENT '공연 시작 시간'")
    private LocalDateTime goodsDate;

    @Column(name = "ticket_information", columnDefinition = "VARCHAR(255) COMMENT '공연 정보'")
    private String goodsInformation;

    @Column(name = "goods_grade", columnDefinition = "FLOAT(20) COMMENT '공연 평점'")
    private float goodsGrade;

    @OneToMany(mappedBy = "ticket")
    private List<TicketReply> ticketReplyList = new ArrayList<>();

    public void setTicketReplyList(List<TicketReply> ticketReplyList) {
        ticketReplyList.stream().forEach(ticketReply -> {
            ticketReply.setTicket(this);
        });
    }


    public void ticketUpdate(GoodsUpdateDTO goodsUpdateDTO) {
//        this.ticketName = ticketUpdateDTO.getTicketName();
//        this.period = ticketUpdateDTO.getPeriod();
//        this.address = ticketUpdateDTO.getAddress();
//        this.genre = ticketUpdateDTO.getGenre();
//        this.runningTime = ticketUpdateDTO.getRunningTime();
//        this.ageToWatch = ticketUpdateDTO.getAgeToWatch();
//        this.ticketPrice = ticketUpdateDTO.getTicketPrice();

    }
}
