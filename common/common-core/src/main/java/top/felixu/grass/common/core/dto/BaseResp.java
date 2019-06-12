package top.felixu.grass.common.core.dto;

import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import top.felixu.grass.common.core.exception.ErrorCode;

import java.io.Serializable;
import java.util.stream.Collectors;

/**
 * 统一返回格式
 *
 * @author felixu
 * @date 2019.06.11
 */
@AllArgsConstructor
public class BaseResp<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public int ret;

    public String msg;

    public T data;

    public static <T> BaseResp<T> onSuc() {
        return onSuc(null);
    }

    public static <T> BaseResp<T> onSuc(T data) {
        return build(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMsg(), data);
    }

    public static <T> BaseResp<T> onValidFail(BindingResult result) {
        String errorMsg = result.getAllErrors()
                .stream()
                .map(objectError -> {
                    FieldError error = (FieldError) objectError;
                    return error.getField() + ", " + error.getDefaultMessage();
                })
                .collect(Collectors.joining("\n"));
        return build(ErrorCode.FAIL.getCode(), errorMsg, null);
    }

    public static <T> BaseResp<T> onFail(ErrorCode errorCode) {

        return onFail(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> BaseResp<T> onFail(int code, String msg) {
        return build(code, msg, null);
    }

    private static <T> BaseResp<T> build(int ret, String msg, T data) {
        return new BaseResp<T>(ret, msg, data);
    }
}
