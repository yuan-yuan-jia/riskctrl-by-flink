package com.jyy.riskctrl.utils.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 基于LocalDate封装的时间工具类
 */
public class DateUtil {


    /*
     *SimpleDateFormat是线程不安全的
     * Date对象设计非常糟糕的类，java官方不建议使用Date
     *
     * LocalDate / LocalDateTime是线程安全的
     */

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";


    private static DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(PATTERN);
    }




    /*
       LocalDateTime 和 String 的互相转换
     */

    public static String convertLocalDateTime2Str(LocalDateTime dateTime) {
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter();
        return dateTimeFormatter.format(dateTime);
    }

    public static LocalDateTime convertStr2LocalDateTime(String str) {
        return LocalDateTime.parse(str, getDateTimeFormatter());
    }

    /*
      时间戳和LocalDateTime互相转换
     */

    public static LocalDateTime convertTimestamp2LocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static long convertLocalDateTime2Timestamp(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

}
