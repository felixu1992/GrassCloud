package top.felixu.grass.baseserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author felixu
 * @date 2019.07.12
 */
@Data
@Component
@ConfigurationProperties(prefix = "grass.auth")
@EnableConfigurationProperties(AuthProperties.class)
public class AuthProperties {

    /**
     * Authorization值
     */
    private String value;

    /**
     * Authorization值
     */
    private String type;
}
