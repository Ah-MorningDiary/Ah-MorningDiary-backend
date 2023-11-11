package com.example.A.chime.diary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5173","http://127.0.0.1:3000") // 요청하는 쪽 origin
                .allowedMethods("*") // http 모든 메소드 요청 허용
                .allowedHeaders("*") // 헤더 정보 모두 허용
                .allowCredentials(true) ;// 쿠키, 세션 정보도 허용

    }
}