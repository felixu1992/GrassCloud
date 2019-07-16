package top.felixu.grass.common.core.utils;

import org.springframework.web.context.request.RequestAttributes;
import top.felixu.grass.common.core.constants.GrassConstants;
import top.felixu.grass.common.core.constants.UserConstants;

/**
 * 用户相关操作
 *
 * @author felixu
 * @date 2019.07.13
 */
public class UserUtils {

    /**
     * 获取当前用户的token
     *
     * @return token
     */
    public static String getCurrentToken() {
        return HttpUtils.getHeaders().get(GrassConstants.Oauth.AUTHORIZATION);
    }

    /**
     * 获取当前请求用户的userId
     *
     * @return userId
     */
    public static long getCurrentUserId() {
        String userIdStr = (String) HttpUtils.getRequestAttributes().getAttribute(UserConstants.Field.USER_ID,
                RequestAttributes.SCOPE_REQUEST);
        return Long.parseLong(ValueUtils.nullAs(userIdStr, GrassConstants.Default.STRANGER_USER_ID));
    }
}
