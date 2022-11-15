package com.system.Flatform.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AgeToWatch {

    ALL("ALL", "전체 연령가"),
    SEVEN("SEVEN", "7세 이용가"),
    TWELVE("TWELVE", "12세 이용가");

    private final String key;
    private final String value;
}
