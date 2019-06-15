package top.felixu.grass.oauthserver.config;

import org.springframework.stereotype.Component;
import top.felixu.grass.common.core.utils.MD5Utils;

/**
 * 自定义PasswordEncoder
 *
 * @author felixu
 * @date 2019.06.14
 */
@Component
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Utils.encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
