package top.felixu.grass.common.logging.logger;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 日志实体
 *
 * @author felixu
 * @date 2019.06.17
 */
@Data
public class AccessLoggerInfo {
    /**
     * 操作描述
     */
    private String action;
    /**
     * 请求方法
     */
    private Method method;
    /**
     * 请求目标类
     */
    private Class target;
    /**
     * 请求入参
     */
    private Map<String, Object> parameters;
    /**
     * 请求ip
     */
    private String ip;
    /**
     * 请求路径
     */
    private String url;
    /**
     * 请求头信息
     */
    private Map<String, String> httpHeaders;
    /**
     * Http请求方式
     */
    private String httpMethod;
    /**
     * 响应体
     */
    private Object response;
    /**
     * 访问时间
     */
    private long requestTime;
    /**
     * 响应时间
     */
    private long responseTime;
    /**
     * 请求响应时长
     */
    private long duration;
    /**
     * 异常
     */
    private Throwable error;
}
