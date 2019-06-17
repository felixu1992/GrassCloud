package top.felixu.grass.common.logging.support;


import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.core.Ordered;
import top.felixu.grass.common.core.utils.HttpUtils;
import top.felixu.grass.common.logging.annotation.AccessLogger;
import top.felixu.grass.common.logging.aop.MethodInterceptorHolder;
import top.felixu.grass.common.logging.logger.AccessLoggerInfo;
import top.felixu.grass.common.logging.logger.AccessLoggerListener;
import top.felixu.grass.common.logging.utils.AopUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 静态方法切点
 *
 * @author felixu
 * @date 2019.06.17
 */
public class AccessLoggerSupport extends StaticMethodMatcherPointcutAdvisor {

    private final List<AccessLoggerListener> listeners = new ArrayList<>();

    public AccessLoggerSupport addListener(AccessLoggerListener loggerListener) {
        listeners.add(loggerListener);
        return this;
    }

    public AccessLoggerSupport() {

        setAdvice((MethodInterceptor) methodInvocation -> {
            MethodInterceptorHolder methodInterceptorHolder = MethodInterceptorHolder.create(methodInvocation);
            AccessLoggerInfo info = createLogger(methodInterceptorHolder);
            Object response;
            try {
                response = methodInvocation.proceed();
                info.setResponse(response);
                info.setResponseTime(System.currentTimeMillis());
            } catch (Throwable e) {
                info.setException(e);
                throw e;
            } finally {
                listeners.forEach(listener -> listener.onLogger(info));
            }
            return response;
        });
    }

    protected AccessLoggerInfo createLogger(MethodInterceptorHolder holder) {
        AccessLoggerInfo info = new AccessLoggerInfo();
        info.setRequestTime(System.currentTimeMillis());

        AccessLogger ann = holder.findAnnotation(AccessLogger.class);
        info.setAction(ann.value());
        info.setDescribe(ann.description());
        info.setParameters(holder.getArgs());
        info.setTarget(holder.getTarget().getClass());
        info.setMethod(holder.getMethod());

        HttpServletRequest request = HttpUtils.getHttpServletRequest();
        if (null != request) {
            info.setHttpHeaders(HttpUtils.getHeaders(request));
            info.setIp(HttpUtils.getIpAddress(request));
            info.setHttpMethod(request.getMethod());
            // info.setUrl(request.getRequestURL().toString());
            info.setUrl(request.getRequestURI());
        }
        return info;

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return null != AopUtils.findAnnotation(aClass, method, AccessLogger.class);
    }
}
