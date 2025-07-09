package com.br.sistemaescolar.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI customApi(){
        return new OpenAPI().info(new Info()
                .title("API - Sistema Escolar Simples")
                .version("v1")
                .description("RESTful API developed with the purpose of managing school information such as classes and students. It offers complete CRUD operations for the involved entities.")
        );
    }
}
