package top.felixu.grass.baseserver.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import top.felixu.grass.baseserver.remote.hystrix.OauthServerHystrix;
import top.felixu.grass.common.core.constant.GrassConstant;
import top.felixu.grass.common.core.dto.oauth.JwtDTO;

/**
 * 远程调度认证服务器接口
 *
 * @author felixu
 * @date 2019.06.15
 */
@FeignClient(name = GrassConstant.Server.OAUTH, fallback = OauthServerHystrix.class)
public interface OauthServerClient {

    /**
     * 远程调用OauthServer获取token
     *
     * @param authorization 认证服务授权客户端
     * @param grantType 授权类型，固定password
     * @param username 用户工号
     * @param password 用户密码
     * @return JWT信息封装
     */
    @PostMapping("/oauth/token")
    JwtDTO getToken(@RequestHeader("Authorization") String authorization,
                    @RequestParam("grant_type") String grantType,
                    @RequestParam("username") String username,
                    @RequestParam("password") String password);
}
