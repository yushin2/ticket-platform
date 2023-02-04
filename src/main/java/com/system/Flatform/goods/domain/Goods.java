package com.system.Flatform.goods.domain;

import com.system.Flatform.goods.record.GoodsUpdateDTO;
import com.system.Flatform.utils.BaseEntity;
import com.system.Flatform.utils.enums.AgeToWatch;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 공연 도메인
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "goods")
public class Goods extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "goods_name", columnDefinition = "VARCHAR(255) COMMENT '공연명'")
    private String goodsName;

    @Column(name = "period", columnDefinition = "VARCHAR(255) COMMENT '공연기간'")
    private String goodsPeriod;

    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '공연장 주소'")
    private String goodsAddress;

    @Column(name = "running_time", columnDefinition = "INT(20) COMMENT '공연시간'")
    private int runningTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_to_watch", columnDefinition = "VARCHAR(50) COMMENT '시청 연령가'")
    private AgeToWatch ageToWatch;

    @Column(name = "goods_date", columnDefinition = "DATETIME COMMENT '공연 시작 날짜시간 정보'")
    private LocalDateTime goodsDate;

    @Column(name = "goods_information", columnDefinition = "VARCHAR(255) COMMENT '공연 정보'")
    private String goodsInformation;

    @Column(name = "goods_grade", columnDefinition = "FLOAT(20) COMMENT '공연 평점'")
    private float goodsGrade;

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsReply> goodsReplyList = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsPrice> goodsPriceList = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsFile> goodsFileList = new ArrayList<>();

    @Builder
    public Goods(String goodsName, String goodsPeriod, String goodsAddress, int runningTime, AgeToWatch ageToWatch, LocalDateTime goodsDate, String goodsInformation, float goodsGrade) {
        this.goodsName = goodsName;
        this.goodsPeriod = goodsPeriod;
        this.goodsAddress = goodsAddress;
        this.runningTime = runningTime;
        this.ageToWatch = ageToWatch;
        this.goodsDate = goodsDate;
        this.goodsInformation = goodsInformation;
        this.goodsGrade = goodsGrade;
    }

    public void setGoodsReplyList(List<GoodsReply> goodsReplyList) {
        goodsReplyList.stream().forEach(ticketReply -> {
            ticketReply.setGoods(this);
        });
    }

    public void setGoodsPriceList(List<GoodsPrice> goodsPriceList) {
        goodsPriceList.stream().forEach(goodsPrice -> {
            goodsPrice.setGoods(this);
        });
    }

    public void setGoodsFileList(List<GoodsFile> goodsFileList) {
        goodsFileList.stream().forEach(goodsFile -> {
            goodsFile.setGoods(this);
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
