package com.digitalinnovation.parking.config;

/**
 * Na versão 3 do Swagger esse arquivo não é mais válido para configuração
 *
 * na open-api
 *
 * Está funcionando na url http://localhost:8080/swagger-ui/index.html
 *
 * e as configurações possíveis basta colocar em application.properties
 */

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
/*


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.parking"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Parking REST API")
                .description("Spring Boot REST API for Parking")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                //.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
}
*/