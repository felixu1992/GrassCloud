package top.felixu.grass.gatewayserver.handler.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.Optional;

/**
 * @author felixu
 * @date 2019.05.16
 */
@Component
public class SecurityHandler implements HandlerFunction<ServerResponse> {

    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

//    @Autowired(required = false)
//    public SecurityHandler(SecurityConfiguration securityConfiguration) {
//        this.securityConfiguration = Optional
//                .ofNullable(securityConfiguration)
//                .orElse(SecurityConfigurationBuilder.builder().build());
//    }

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        this.securityConfiguration = Optional
                .ofNullable(securityConfiguration)
                .orElse(SecurityConfigurationBuilder.builder().build());
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(securityConfiguration));
    }
}
