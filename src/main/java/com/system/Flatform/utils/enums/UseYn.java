package com.system.Flatform.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UseYn {

    Y("Y", "USE"),
    N("N", "NOT_USED");

    private final String key;
    private final String value;
}
