package top.felixu.grass.common.logging.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author felixu
 * @date 2019.06.17
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AccessLogger {

    /**
     * 操作描述
     *
     * @return description
     */
    @AliasFor("description")
    String value() default "";

    /**
     * 操作描述
     *
     * @return description
     */
    @AliasFor("value")
    String description() default "";
}
