package top.felixu.grass.common.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author felixu
 * @date 2019.06.11
 */
@Getter
@ToString
@AllArgsConstructor
public enum ErrorCode {
    /**
     * 自定义错误
     */
    SUCCESS(0, "OK"),
    FAIL(-1, "操作失败"),
    RPC_ERROR(-2, "远程调度失败"),
    DB_ERROR(-3, "数据操作失败"),

    PARAM_NPE(100, "参数为空"),
    PARAM_ERROR(101, "参数错误"),


    PASSWORD_ERROR(2000, "账号或密码错误，请重新输入"),
    LOGIN_ERROR(2001, "登陆失败，请稍后重试"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;
}
