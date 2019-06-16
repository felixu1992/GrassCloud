package top.felixu.grass.baseserver;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.felixu.grass.baseserver.remote.OauthServerClient;
import top.felixu.grass.common.core.constant.GrassConstant;
import top.felixu.grass.common.core.dto.BaseResp;
import top.felixu.grass.common.core.dto.oauth.JwtDTO;
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
@ComponentScan(GrassConstant.BasePackage.NAME)
public class BaseServerApplication {

	private final OauthServerClient oauthServerClient;

	public static void main(String[] args) {
		SpringApplication.run(BaseServerApplication.class, args);
	}

	@GetMapping("/oauth/token")
	public BaseResp<JwtDTO> getToken(@RequestParam("username") String username,
									 @RequestParam("password") String password) {
		return BaseResp.onSuc(oauthServerClient.getToken("Basic Z3Jhc3M6ZmVsaXh1", "password",
				username, password));
	}
}
