package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServiceConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //모든 요청에 대해서
                .allowedOrigins("https://ee9a-219-255-158-172.jp.ngrok.io", "https://35cf-219-255-158-172.jp.ngrok.io", "http://localhost:5500", "http://10.21.20.18:5500")
                .allowCredentials(true); //허용할 오리진들
    }
}
