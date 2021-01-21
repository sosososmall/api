package com.pokerstar.api.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static Logger Log = LoggerFactory.getLogger(DateTimeUtil.class);

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static DateTimeFormatter dateTimeFormatterWithNoJoiner = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter dateFormatterWithNoJoiner = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static DateTimeFormatter timeFormatterWithNoJoiner = DateTimeFormatter.ofPattern("HHmmss");

    /**
     * 获取当前时间戳 秒级
     *
     * @return
     */
    public static long getCurrentSecondTimestamp() {
        Instant instant = Instant.now().atZone(ZoneOffset.of("+8")).toInstant();
        return instant.getEpochSecond();
    }

    /**
     * 获取当前时间戳 毫秒级
     *
     * @return
     */
    public static long getCurrentMillSecondTimestamp() {
        Instant instant = Instant.now().atZone(ZoneOffset.of("+8")).toInstant();
        return instant.toEpochMilli();
    }

    public static String getCurrentTimeStr() {
        return LocalDateTime.now(ZoneOffset.of("+8")).format(dateTimeFormatter);
    }

    public static String getTimeStr(DateTimeFormatter formatter) {
        return LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
    }

    public static long getTodayStartTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toEpochSecond(ZoneOffset.of("+8"));
    }

    public static long getTodayEndTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8"));
    }

    public static LocalDateTime secondTimestamp2DateTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneOffset.of("+8"));
    }

    public static LocalDateTime millisTimestamp2DateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneOffset.of("+8"));
    }
}
