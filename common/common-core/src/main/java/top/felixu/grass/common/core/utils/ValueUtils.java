package top.felixu.grass.common.core.utils;

/**
 * 对值进行处理的工具
 *
 * @author felixu
 * @date 2019.06.12
 */
public class ValueUtils {

    /**
     * 用于处理可能为null的值，避免判断null，并设置默认值
     *
     * @param value 待判断的值
     * @param def 默认值
     * @param <T> 范型对象
     * @return 返回对象值
     */
    public static <T> T nullAs(T value, T def) {
        if (null == value) {
            return def;
        }
        return value;
    }
}
