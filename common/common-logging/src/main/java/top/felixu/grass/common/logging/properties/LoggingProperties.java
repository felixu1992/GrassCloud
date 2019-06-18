package top.felixu.grass.common.logging.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author felixu
 * @date 2019.06.18
 */
@Data
@Component
@ConfigurationProperties(LoggingProperties.PREFIX)
@EnableConfigurationProperties(LoggingProperties.class)
public class LoggingProperties {

    /**
     * prefix
     */
    public static final String PREFIX = "grass.logging";
    /**
     * 日志开关，默认开启
     */
    private boolean enable = true;
}
