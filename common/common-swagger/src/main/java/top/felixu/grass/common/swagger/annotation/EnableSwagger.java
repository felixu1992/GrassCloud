package top.felixu.grass.common.swagger.annotation;

import org.springframework.context.annotation.Import;
import top.felixu.grass.common.swagger.config.SwaggerAutoConfiguration;

import java.lang.annotation.*;

/**
 * Enable模式的Swagger开关
 *
 * @author felixu
 * @date 2019.05.15
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {SwaggerAutoConfiguration.class})
public @interface EnableSwagger {

}
