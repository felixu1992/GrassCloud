package top.felixu.grass.common.logging.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * ThreaLocal工具类
 *
 * @author felixu
 * @date 2019.06.17
 */
public class ThreadLocalUtils {

    private static final ThreadLocal<Map<String, Object>> LOCAL = ThreadLocal.withInitial(HashMap::new);

    public static <T> T put(String key, T value) {
        LOCAL.get().put(key, value);
        return value;
    }

    public static void remove(String key) {
        LOCAL.get().remove(key);
    }

    public static void clear() {
        LOCAL.remove();
    }

    public static <T> T get(String key) {
        return ((T) LOCAL.get().get(key));
    }

    public static <T> T get(String key, Supplier<T> other) {
        T val = ((T) LOCAL.get().get(key));
        if (null != val) return val;
        val = other.get();
        LOCAL.get().put(key, val);
        return val;
    }

    public static <T> T getAndRemove(String key) {
        try {
            return ((T) LOCAL.get().get(key));
        } finally {
            LOCAL.get().remove(key);
        }
    }
}
