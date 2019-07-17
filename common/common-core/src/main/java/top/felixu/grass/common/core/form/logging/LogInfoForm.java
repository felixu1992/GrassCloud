package top.felixu.grass.common.core.form.logging;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author felixu
 * @date 2019.06.18
 */
@Data
public class LogInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 来源服务
     */
    public String serverName;

    /**
     * 操作描述
     */
    private String action;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求目标类
     */
    private String target;

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

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;
}
