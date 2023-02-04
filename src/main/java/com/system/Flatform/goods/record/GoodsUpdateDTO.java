package com.system.Flatform.goods.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.Flatform.utils.enums.AgeToWatch;

import java.time.LocalDateTime;

/**
 * 공연 수정 record
 */
public record GoodsUpdateDTO(

        Long goodsId,
        String goodsName,
        String goodsPeriod,
        String goodsAddress,
        int runningTime,
        AgeToWatch ageToWatch,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asis/Seoul")
        LocalDateTime goodsDate,
        String goodsInformation
) {
}
