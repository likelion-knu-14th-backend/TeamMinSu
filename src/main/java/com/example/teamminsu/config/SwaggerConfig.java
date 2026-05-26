package com.example.teamminsu.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.info;

@Configuration
public class SwaggerConfig {
    private final String AUTH_TOKEN_HEADER = "Authorization";

    public Info apiInfo() {
        return new Info()
            .title("나만의 API")
            .description("학생정보 REST API 문서")
            .version("1.0.0");
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .addSecurityItem(new SecurityRequirement().addList(AUTH_TOKEN_HEADER))
                .components(new Components()
                        .addSecuritySchemes(AUTH_TOKEN_HEADER, new SecurityScheme()
                                .name(AUTH_TOKEN_HEADER)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
