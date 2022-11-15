package com.system.Flatform.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DelYn {

    Y("Y", "NOT_USED"),
    N("N", "USE");

    private final String key;
    private final String value;
}
