package top.felixu.grass.common.core.enums;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * 时间格式化的格式枚举
 *
 * @author felixu
 * @date 2019.09.23
 */
public enum DateFormatPattern {

    /**
     * 时分秒
     */
    FULL_DATE_TIME_SECONDS("yyyy-MM-dd HH:mm:ss");

    String pattern;
    DateTimeFormatter formatter;

    DateFormatPattern(String pattern) {
        this.pattern = pattern;
        this.formatter = DateTimeFormatter.ofPattern(this.pattern);
    }

    public String format(TemporalAccessor source) {
        return this.formatter.format(source);
    }

    public String now() {
        return this.formatter.format(LocalDateTime.now());
    }
}
