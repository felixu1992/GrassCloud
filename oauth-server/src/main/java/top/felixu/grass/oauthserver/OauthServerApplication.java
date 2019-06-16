package top.felixu.grass.oauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import top.felixu.grass.common.core.constant.GrassConstant;

/**
 * @author felixu
 * @date 2019.6.15
 */
@EnableFeignClients
@SpringCloudApplication
@MapperScan(GrassConstant.BasePackage.NAME)
@ComponentScan(GrassConstant.BasePackage.NAME)
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
