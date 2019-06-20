package top.felixu.grass.gatewayserver.ext.swagger;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import top.felixu.grass.common.core.constants.GrassConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 聚合文档
 *
 * @author felixu
 * @date 2019.05.16
 * @see springfox.documentation.swagger.web.SwaggerResourcesProvider
 */
@Primary
@Component
@AllArgsConstructor
public class SwaggerResourcesProvider implements springfox.documentation.swagger.web.SwaggerResourcesProvider {

    private static final String API_URI = "/v2/api-docs";
    private static final String SWAGGER_VERSION = "2.0";
    private static final String EUREKA_SUB_PREFIX = "CompositeDiscoveryClient_";
    private static final String PATTERN = "pattern";
    private static final List<String> IGNORE = Arrays.asList(GrassConstants.Server.GATEWAY,
            GrassConstants.Server.CONFIG, GrassConstants.Server.OAUTH);

    private final DiscoveryClientRouteDefinitionLocator routeLocator;

    @Override

    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        //从DiscoveryClientRouteDefinitionLocator 中取出routes，构造成swaggerResource
        routeLocator.getRouteDefinitions().subscribe(routeDefinition -> {
            String serverName = routeDefinition.getId().substring(EUREKA_SUB_PREFIX.length());
            if (IGNORE.stream().noneMatch(server -> server.equalsIgnoreCase(serverName))) {
                resources.add(createSwaggerResource(serverName,
                        routeDefinition.getPredicates().get(0).getArgs().get(PATTERN).replace("/**", API_URI)));
            }
        });

        return resources;

    }

    private SwaggerResource createSwaggerResource(String name, String location) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(SWAGGER_VERSION);
        return resource;
    }
}
