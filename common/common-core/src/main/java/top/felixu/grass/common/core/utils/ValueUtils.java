package top.felixu.grass.common.core.utils;

import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import top.felixu.grass.common.core.exception.ErrorCode;
import top.felixu.grass.common.core.exception.GrassException;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 对值进行处理的工具
 *
 * @author felixu
 * @date 2019.06.12
 */
public class ValueUtils {

    /**
     * 用于处理可能为null的值，避免判断null，并设置默认值
     *
     * @param value 待判断的值
     * @param def 默认值
     * @param <T> 范型对象
     * @return 返回对象值
     */
    public static <T> T nullAs(T value, T def) {
       return Optional.ofNullable(value)
                .orElse(def);
    }

    public static void checkParams(BindingResult result) {
        if (!ObjectUtils.isEmpty(result)
                && result.hasErrors()) {
            String errorMsg = result.getAllErrors()
                    .stream()
                    .map(objectError -> {
                        FieldError error = (FieldError) objectError;
                        return error.getField() + ", " + error.getDefaultMessage();
                    })
                    .collect(Collectors.joining("\n"));
            throw new GrassException(ErrorCode.PARAM_ERROR, errorMsg);
        }
    }
}