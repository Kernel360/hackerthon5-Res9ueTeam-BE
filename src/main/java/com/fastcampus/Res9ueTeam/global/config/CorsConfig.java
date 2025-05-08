package com.fastcampus.Res9ueTeam.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("https://hackerthon5-res9ue-team-fe.vercel.app")); // 허용할 Origin
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 허용할 HTTP Method
        config.setAllowedHeaders(List.of("*")); // 모든 헤더 허용
        config.setAllowCredentials(true); // 인증 정보 허용 (ex. 쿠키)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 모든 요청 경로에 대해 적용
        return source;
    }
}
