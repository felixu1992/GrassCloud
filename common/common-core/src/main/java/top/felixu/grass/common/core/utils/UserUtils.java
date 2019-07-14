package top.felixu.grass.common.core.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import top.felixu.grass.common.core.constants.GrassConstants;

/**
 * 用户相关操作
 *
 * @author felixu
 * @date 2019.07.13
 */
@Component
public class UserUtils {

    /**
     * 获取当前用户的token
     *
     * @return token
     */
    public static String getCurrentAuth() {
        return HttpUtils.getHeaders().get(GrassConstants.Oauth.AUTHORIZATION);
    }

    /**
     * 获取当前请求用户的userId
     *
     * @return userId
     */
    public static long getCurrentUserId() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Long.parseLong(ValueUtils.nullAs(userId, GrassConstants.Default.STRANGER_USER_ID));
    }
}
