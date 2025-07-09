package com.example.imposto.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.imposto.component.JwtFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> filtroJwt() {
        FilterRegistrationBean<JwtFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new JwtFilter());
        bean.addUrlPatterns("/api/*");
        return bean;
    }
    
}
