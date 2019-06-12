package top.felixu.grass.common.core.exception;

import lombok.Getter;

/**
 * 统一抛出错误
 *
 * @author felixu
 * @date 2019.06.11
 */
@Getter
public class GrassException extends RuntimeException {

    private ErrorCode errorCode;

    private int code;

    private String msg;

    public GrassException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMsg());
    }

    public GrassException(ErrorCode errorCode, String msg) {
        this(errorCode.getCode(), msg);
        this.errorCode = errorCode;
    }

    public GrassException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}