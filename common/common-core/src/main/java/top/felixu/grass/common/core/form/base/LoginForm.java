package top.felixu.grass.common.core.form.base;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author felixu
 * @date 2019.07.12
 */
@Data
public class LoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名、手机号、邮箱
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 短信验证码
     */
    private String smsCode;

    /**
     * 验证码
     */
    private String validateCode;
}
