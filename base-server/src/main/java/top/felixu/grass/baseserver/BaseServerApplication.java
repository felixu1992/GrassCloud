package top.felixu.grass.baseserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import top.felixu.grass.common.swagger.annotation.EnableSwagger;

@EnableSwagger
@SpringCloudApplication
public class BaseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}

}
