package top.felixu.grass.common.core.utils;

import top.felixu.grass.common.core.constants.GrassConstants;

/**
 * 用户相关操作
 *
 * @author felixu
 * @date 2019.07.13
 */
public class UserUtils {

    public static String getCurrentAuth() {
        return HttpUtils.getHeaders().get(GrassConstants.Oauth.AUTHORIZATION);
    }

//    public static
}
