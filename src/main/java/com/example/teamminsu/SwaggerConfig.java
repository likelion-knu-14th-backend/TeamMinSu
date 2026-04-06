package com.example.teamminsu;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("석훈이의 과제 API")
                        .description("과제 및 학생 정보 통합 API 문서")
                        .version("1.0.0"));
    }
}