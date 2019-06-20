package top.felixu.grass.gatewayserver.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import top.felixu.grass.gatewayserver.handler.swagger.ResourceHandler;
import top.felixu.grass.gatewayserver.handler.swagger.SecurityHandler;
import top.felixu.grass.gatewayserver.handler.swagger.UiHandler;

/**
 * @author felixu
 * @date 2019.05.16
 */
@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {

    private final ResourceHandler resourceHandler;

    private final SecurityHandler securityHandler;

    private final UiHandler uiHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/swagger-resources")
                        .and(RequestPredicates.accept(MediaType.ALL)), resourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), securityHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), uiHandler);
    }
}
