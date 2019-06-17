package top.felixu.grass.common.logging.logger;

/**
 * 日志注解
 *
 * @author felixu
 * @date 2019.06.17
 */
public interface AccessLoggerListener {
    /**
     * 由子类实现，具体的保存日志逻辑
     *
     * @param loggerInfo 日志对象
     * @see AccessLoggerInfo
     */
    void onLogger(AccessLoggerInfo loggerInfo);
}
