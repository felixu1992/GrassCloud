package top.felixu.grass.common.logging.utils;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Aop工具类
 *
 * @author felixu
 * @date 2019.06.17
 */
public class AopUtils {

    public static <T extends Annotation> T findAnnotation(Class targetClass, Method method, Class<T> annClass) {
        Method m = method;
        T a = AnnotationUtils.findAnnotation(m, annClass);
        if (a != null) return a;
        m = ClassUtils.getMostSpecificMethod(m, targetClass);
        a = AnnotationUtils.findAnnotation(m, annClass);
        if (a != null) return a;
        return AnnotationUtils.findAnnotation(targetClass, annClass);
    }
}