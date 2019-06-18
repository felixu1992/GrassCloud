package top.felixu.grass.loggingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import top.felixu.grass.common.core.constants.GrassConstants;

/**
 * @author felixu
 * @date 2019.06.18
 */
@EnableFeignClients
@SpringCloudApplication
@ComponentScan(GrassConstants.BasePackage.NAME)
public class LoggingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingServerApplication.class, args);
    }

}
