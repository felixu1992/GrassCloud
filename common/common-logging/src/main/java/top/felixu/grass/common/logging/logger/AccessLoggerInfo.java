package top.felixu.grass.common.logging.logger;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 日志实体
 *
 * @author felixu
 * @date 2019.06.17
 */
@Data
public class AccessLoggerInfo implements Serializable {

    private String action;

    private String describe;

    private Method method;

    private Class target;

    private Map<String, Object> parameters;

    private String ip;

    private String url;

    private Map<String, String> httpHeaders;

    private String httpMethod;

    private Object response;

    private long requestTime;

    private long responseTime;

    private Throwable exception;
}
