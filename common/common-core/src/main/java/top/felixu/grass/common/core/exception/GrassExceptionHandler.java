//package top.felixu.grass.common.core.exception;
//
//import com.codeblock.backend.common.dto.BaseResp;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.nio.file.AccessDeniedException;
//
//public class ServiceExceptionHandler {
//
//    private Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);
//
//    @ExceptionHandler
//    @ResponseBody
//    public ResponseEntity<BaseResp<Object>> handleException(Exception e, HttpServletResponse servletResponse) {
//
//        logger.error("ServiceExceptionHandler", e);
//
//        BaseResp<Object> resp = new BaseResp<>();
//        HttpStatus status;
//        if (e instanceof ServiceException) {
//            status = HttpStatus.OK;
//            ServiceException ccException = (ServiceException) e;
//            resp.ret = ccException.getCode();
//            resp.msg = ccException.getMessage();
//        } else if (e instanceof AccessDeniedException || e instanceof SecurityException) {
//            status = HttpStatus.FORBIDDEN;
//            resp.ret = HttpStatus.FORBIDDEN.value();
//            resp.msg = "拒绝访问";
//        } else {
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//            resp.ret = HttpStatus.INTERNAL_SERVER_ERROR.value();
//            resp.msg = "服务器错误";
//        }
//        return new ResponseEntity<>(resp, status);
//    }
//}
