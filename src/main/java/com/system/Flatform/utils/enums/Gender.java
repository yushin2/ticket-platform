package com.system.Flatform.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    M("M", "남성"),
    F("F", "여성");

    private final String key;
    private final String value;
}
