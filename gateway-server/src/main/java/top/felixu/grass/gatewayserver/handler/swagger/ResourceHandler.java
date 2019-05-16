package top.felixu.grass.gatewayserver.handler.swagger;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author felixu
 * @date 2019.05.16
 */
@Component
@AllArgsConstructor
public class ResourceHandler implements HandlerFunction<ServerResponse> {

    private SwaggerResourcesProvider provider;

    @Nullable
    @Override
    public Mono<ServerResponse> handle(@Nullable ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(provider.get()));
    }
}
