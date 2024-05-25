package com.cathaybk.weitest.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 日期時間工具
 *
 * @auther wei
 */
public class DateTimeUtil {

    public static LocalDateTime convertToLocalDateTime(String timestampStr) {
        long timestamp = Long.parseLong(timestampStr);
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
