package top.felixu.grass.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.felixu.grass.common.utils.SwaggerExtUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @author felixu
 * @date 2019.04.23
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    String appName;

    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
                .description("Authorization Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;

    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(SwaggerExtUtils.basePackage("top.felixu.grass.*.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameter());


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName + "'S API")
                .description(appName)
                .termsOfServiceUrl("https://github.com/felixu1992/GrassCloud")
                .contact(new Contact("felixu", "https://blogs.felixu.top", "xufei_0320@163.com"))
                .license("Apache License 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
}
