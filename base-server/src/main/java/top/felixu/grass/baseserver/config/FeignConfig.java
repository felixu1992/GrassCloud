package top.felixu.grass.baseserver.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author felixu
 * @date 2019.07.12
 */
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Cookie", "aaaaaaaa");
    }
}
