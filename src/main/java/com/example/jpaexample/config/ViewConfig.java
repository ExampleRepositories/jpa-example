package com.example.jpaexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
public class ViewConfig {

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setPrefix("/src/main/webapp/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
