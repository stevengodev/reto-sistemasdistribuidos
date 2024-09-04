package com.foliaco.reto_mongo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite CORS en todos los endpoints
                        .allowedOrigins("*") // Permite todos los orígenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite todos los métodos HTTP
                        .allowedHeaders("*") // Permite todas las cabeceras
                        .allowCredentials(false); // No permite enviar credenciales
            }
        };
    }
}
