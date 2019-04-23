package top.felixu.grass.common.utils;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;
import java.util.regex.Pattern;

/**
 * 对Swagger中部分方法进行重写，使其支持多包扫描，或者正则匹配
 * 重写{@link springfox.documentation.builders.RequestHandlerSelectors}中basePackage(java.lang.String)方法
 *
 * @author felixu
 * @date 2019.04.23
 * @see springfox.documentation.builders.RequestHandlerSelectors
 */
public class SwaggerExtUtils {

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> {
            assert input != null;
            return declaringClass(input).transform(handlerPackage(basePackage)).or(true);
        };
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            assert input != null;
            String inputPackageName = input.getPackage().getName();
            for (String packageName : basePackage.split(",")) {
                boolean isMatch = inputPackageName.startsWith(packageName);
                if (isMatch) {
                    return true;
                }
                Pattern pattern = Pattern.compile(packageName);
                isMatch = pattern.matcher(inputPackageName).find();
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
