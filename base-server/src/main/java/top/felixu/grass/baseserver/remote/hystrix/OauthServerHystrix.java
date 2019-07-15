package top.felixu.grass.baseserver.remote.hystrix;

import org.springframework.stereotype.Component;
import top.felixu.grass.baseserver.remote.OauthServerClient;
import top.felixu.grass.common.core.dto.oauth.JwtDTO;

/**
 * @author felixu
 * @date 2019.06.15
 */
@Component
public class OauthServerHystrix implements OauthServerClient {

    @Override
    public JwtDTO getToken(String authorization, String grantType, String username, String password) {
        return null;
    }
}
