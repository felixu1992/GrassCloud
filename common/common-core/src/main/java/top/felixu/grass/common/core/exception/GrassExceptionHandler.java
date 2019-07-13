package top.felixu.grass.common.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.felixu.grass.common.core.dto.BaseResp;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 *
 * @author felixu
 * @date 2019.06.11
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GrassExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BaseResp<Object>> handleException(Exception e, HttpServletResponse servletResponse) {
        log.error("GrassExceptionHandler", e);
        BaseResp<Object> resp;
        HttpStatus status;
        if (e instanceof GrassException) {
            status = HttpStatus.OK;
            GrassException exception = (GrassException) e;
            resp = BaseResp.onFail(exception.getCode(), exception.getMessage());
        } else if (e instanceof AccessDeniedException
                || e instanceof SecurityException) {
            status = HttpStatus.FORBIDDEN;
            resp = BaseResp.onFail(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            resp = BaseResp.onFail(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return new ResponseEntity<>(resp, status);
    }
}
