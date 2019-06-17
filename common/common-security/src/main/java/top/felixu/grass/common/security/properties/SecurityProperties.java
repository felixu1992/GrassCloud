package top.felixu.grass.common.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author felixu
 * @date 2019.06.16
 */
@Data
@Component
@ConfigurationProperties(prefix = "grass.security")
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityProperties {

    /**
     * 不被拦截的路径
     */
    private String[] regexMatchers;
    /**
     * 被拦截的路径
     */
    private String[] antMatchers;
    /**
     * 资源服务器ID
     */
    private String resourceId;
}
