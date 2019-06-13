package top.felixu.grass.baseserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import top.felixu.grass.common.swagger.annotation.EnableSwagger;

@EnableSwagger
@ComponentScan(basePackages = "top.felixu")
@SpringCloudApplication
public class BaseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}

}
