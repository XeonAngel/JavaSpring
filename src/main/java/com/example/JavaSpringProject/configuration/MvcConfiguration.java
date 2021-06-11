package com.example.JavaSpringProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setDefaultErrorView("Exceptions/400");
        resolver.setDefaultStatusCode(400);

        mapNumberFormatException(resolver);

        return resolver;
    }

    public void mapNumberFormatException(SimpleMappingExceptionResolver resolver) {
        Properties mappings = new Properties();
        mappings.setProperty(NumberFormatException.class.getName(), "Exceptions/400");
        mappings.setProperty(EmptyResultDataAccessException.class.getName(), "Exceptions/404");
        resolver.setExceptionMappings(mappings);

        resolver.addStatusCode("Exceptions/400", 400);
        resolver.addStatusCode("Exceptions/404", 404);
    }
}