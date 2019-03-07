package com.osherove.ch7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeLogger {

    public static String createMessage(String info) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + " " + info;
    }

}
