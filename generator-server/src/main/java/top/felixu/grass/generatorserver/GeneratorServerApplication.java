package top.felixu.grass.generatorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.felixu.grass.common.swagger.annotation.EnableSwagger;

@EnableSwagger
@SpringBootApplication
public class GeneratorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorServerApplication.class, args);
    }

}
