package top.felixu.grass.gatewayserver.ext.swagger;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 借鉴学习自：https://yq.aliyun.com/articles/615547，感谢！
 *
 * @author felixu
 * @date 2019.05.16
 * @see springfox.documentation.swagger.web.SwaggerResourcesProvider
 */
@Primary
@Component
@AllArgsConstructor
public class SwaggerResourcesProvider implements springfox.documentation.swagger.web.SwaggerResourcesProvider {

    public static final String API_URI = "/v2/api-docs";
    private static final String SWAGGER_VERSION = "2.0";
    private final RouteDefinitionRepository routeDefinitionRepository;


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<RouteDefinition> routes = new ArrayList<>();
        routeDefinitionRepository.getRouteDefinitions().subscribe(routes::add);
        routes.forEach(routeDefinition -> option(routeDefinition, resources));
        return resources
                .stream()
                .sorted(Comparator.comparing(SwaggerResource::getName))
                .collect(Collectors.toList());
    }

    private void option(RouteDefinition route, List<SwaggerResource> resources) {
        route.getPredicates()
                .stream()
                .filter(predicateDefinition -> "Path".equalsIgnoreCase(predicateDefinition.getName()))
                .forEach(predicateDefinition -> resources.add(createSwaggerResource(route.getId(),
                        predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                .replace("/**", API_URI))));
    }

    private SwaggerResource createSwaggerResource(String name, String location) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(SWAGGER_VERSION);
        return resource;
    }
}
