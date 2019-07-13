package top.felixu.grass.baseserver;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.felixu.grass.common.core.constants.GrassConstants;
import top.felixu.grass.common.core.dto.BaseResp;
import top.felixu.grass.common.swagger.annotation.EnableSwagger;

/**
 * @author felixu
 * @date 2019.6.15
 */
@AllArgsConstructor
@RestController
@EnableSwagger
@EnableFeignClients
@SpringCloudApplication
@ComponentScan(GrassConstants.BasePackage.NAME)
public class BaseServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/test")
	public BaseResp<String> test() {
		return BaseResp.onSuc("SUCCESS");
	}
}
