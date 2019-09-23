package top.felixu.grass.common.core.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间相关操作处理
 * 优先使用 Java 8 的 time api
 *
 * @author felixu
 * @date 2019.07.12
 */
public class DateUtils {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private static final String FORMAT_TO_FULL_STRING_PATTEN = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd
     */
    private static final String FORMAT_TO_SHORT_DATE_STRING_PATTERN = "yyyy-MM-dd";

    /**
     * 将Date类型转为LocalDateTime类型
     *
     * @param date 需要被转换的日期
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    /**
     * 将Date类型转为LocalTime类型
     *
     * @param date 需要被转换的日期
     * @return LocalTime
     */
    public static LocalTime dateToLocalTime(Date date) {
        return dateToLocalDateTime(date).toLocalTime();
    }

    /**
     * 将Date类型转为LocalDate类型
     *
     * @param date 需要被转换的日期
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return dateToLocalDateTime(date).toLocalDate();
    }

    /**
     * 格式化时间为：yyyy-MM-dd HH:mm:ss
     *
     * @param date 需要被转换的时间
     * @return 返回 yyyy-MM-dd HH:mm:ss 格式的时间字符串
     */
    public static String dateToFullString(Date date) {
        return dateToFullString(dateToLocalDateTime(date));
    }

    /**
     * 格式化时间为：yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 需要被转换的时间
     * @return 返回 yyyy-MM-dd HH:mm:ss 格式的时间字符串
     */
    public static String dateToFullString(LocalDateTime localDateTime) {
        return dateFormat(localDateTime, FORMAT_TO_FULL_STRING_PATTEN);
    }

    /**
     * 格式化时间为：yyyy-MM-dd
     *
     * @param date 需要被转换的时间
     * @return 返回 yyyy-MM-dd 格式的时间字符串
     */
    public static String dateToShortDateString(Date date) {
        return dateToShortDateString(dateToLocalDateTime(date));
    }

    /**
     * 格式化时间为：yyyy-MM-dd
     *
     * @param localDateTime 需要被转换的时间
     * @return 返回 yyyy-MM-dd 格式的时间字符串
     */
    public static String dateToShortDateString(LocalDateTime localDateTime) {
        return dateFormat(localDateTime, FORMAT_TO_SHORT_DATE_STRING_PATTERN);
    }

    /**
     * 格式化方法的真正处理的方法
     * 可以传入时间和指定特定的格式化方式完成转换
     * 比如传入当前时间 LocalDateTime.now() 和格式化规则 yyyy年第w周
     *
     * @param localDateTime 需要被转换的时间
     * @param pattern 转换格式
     * @return 按指定格式转换后的结果
     */
    public static String dateFormat(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将LocalDateTime类型转为Date类型
     *
     * @param date 需要被转换的日期
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime date) {
        ZoneId zone = ZoneId.systemDefault();
        return Date.from(date.atZone(zone).toInstant());
    }

    /**
     * 将LocalDate类型转为Date类型
     *
     * @param date 需要被转换的日期
     * @return Date
     */
    public static Date localDateToDate(LocalDate date) {
        ZoneId zone = ZoneId.systemDefault();
        return Date.from(date.atStartOfDay().atZone(zone).toInstant());
    }

    /**
     * 将LocalTime类型转为Date类型
     *
     * @param date 日期
     * @param time 时间
     * @return Date
     */
    public static Date localTimeToDate(LocalDate date, LocalTime time) {
        ZoneId zone = ZoneId.systemDefault();
        return Date.from(LocalDateTime.of(date, time).atZone(zone).toInstant());
    }

    /**
     * 获取给定月份的开始时间
     *
     * @date 给定的日期
     * @return Date
     */
    public static Date atStartOfMonth(LocalDate date) {
        LocalDateTime localDateTime = LocalDateTime.of(date.getYear(), date.getMonth(),
                1, 0, 0, 0);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 获取给定月份的开始时间
     *
     * @date 给定的日期
     * @return Date
     */
    public static Date atStartOfDay(LocalDate date) {
        return localDateTimeToDate(date.atStartOfDay());
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        localDate.isLeapYear();
        Month month = localDate.getMonth();
        LocalTime localTime = LocalTime.now();
    }
}