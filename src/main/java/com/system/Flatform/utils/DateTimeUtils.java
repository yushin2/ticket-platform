package com.system.Flatform.utils;

import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class DateTimeUtils {

    public static LocalTime stringToLocalTime(String stringTime) {
        return LocalTime.parse(stringTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
