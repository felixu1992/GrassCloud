package top.felixu.grass.gatewayserver.handler.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.util.Optional;

/**
 * @author felixu
 * @date 2019.05.16
 */
@Component
public class UiHandler implements HandlerFunction<ServerResponse> {

    @Autowired(required = false)
    private UiConfiguration uiConfiguration;

//    @Autowired(required = false)
//    public UiHandler(UiConfiguration uiConfiguration) {
//        this.uiConfiguration = Optional
//                .ofNullable(uiConfiguration)
//                .orElse(UiConfigurationBuilder.builder().build());
//    }

    @Nullable
    @Override
    public Mono<ServerResponse> handle(@Nullable ServerRequest request) {
        this.uiConfiguration = Optional
                .ofNullable(uiConfiguration)
                .orElse(UiConfigurationBuilder.builder().build());
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(uiConfiguration));
    }
}
