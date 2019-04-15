package com.project.picktoon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**

 WebMvcConfigurer를 구현하고 있는 설정파일은 @WebMvcTest를 사용할 때 호출된다.
 ModelMapper를 다른 설정 파일에 넣으면 찾지 못할 수 가 있다.

 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // webjars 경로 추가...
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/static/webjars/", "classpath:/META-INF/resources/webjars/");
        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
