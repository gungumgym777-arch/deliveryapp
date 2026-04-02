package com.delivery_post.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration     
public class OpenApiConfig {

    @Bean
    public OpenAPI deliveryOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Delivery Cost Calculation API")
                        .description("API for calculating delivery costs based on distance, weight, cargo type, and urgency.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Yeraly")
                                .email("gungumgym777@gmail.com")
                                .url("localhost:8080/api/delivery/calculate")));
    }
}
