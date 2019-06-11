package top.felixu.grass.common.core.exception;

public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;
    private int code;
    private String msg;

    public ServiceException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMsg());
    }

    public ServiceException(ErrorCode errorCode, String msg) {
        this(errorCode.getCode(), msg);
        this.errorCode = errorCode;
    }

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}