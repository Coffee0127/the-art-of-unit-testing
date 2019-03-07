package com.osherove.ch7;

import java.time.format.DateTimeFormatter;

public class TimeLogger {

    public static String createMessage(String info) {
        // 產品程式碼使用 SystemTime
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(SystemTime.now()) + " " + info;
    }

}
