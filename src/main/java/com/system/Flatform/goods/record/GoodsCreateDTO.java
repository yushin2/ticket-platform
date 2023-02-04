package com.system.Flatform.goods.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.goods.domain.Goods;
import com.system.Flatform.utils.enums.AgeToWatch;

import java.time.LocalDateTime;

/**
 * 공연 등록(저장) record
 */
public record GoodsCreateDTO(
        String goodsName,
        String goodsPeriod,
        String goodsAddress,
        int runningTime,
        AgeToWatch ageToWatch,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asis/Seoul")
        LocalDateTime goodsDate,
        String goodsInformation

) {
    public Goods toEntity() {
        return Goods.builder()
                .goodsName(goodsName)
                .goodsPeriod(goodsPeriod)
                .goodsAddress(goodsAddress)
                .runningTime(runningTime)
                .ageToWatch(ageToWatch)
                .goodsDate(goodsDate)
                .goodsInformation(goodsInformation)
                .build();
    }
}
