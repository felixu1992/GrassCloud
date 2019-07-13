package top.felixu.grass.common.core.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author felixu
 * @date 2019.07.13
 */
public class RedisUtils {

    private StringRedisTemplate template = ApplicationUtils.getBean(StringRedisTemplate.class);
}
