package top.felixu.grass.oauthserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author felixu
 * @date 2019.6.15
 */
@EnableFeignClients
@SpringCloudApplication
@MapperScan(basePackages = "top.felixu")
@ComponentScan(basePackages = "top.felixu")
public class OauthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
    }

}
