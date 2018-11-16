package com.project.conf;

import com.project.util.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    LoginInterceptor localInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor())
                .excludePathPatterns("/login**")
                //swagger2拦截配置
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/api-docs")
                .excludePathPatterns("/configuration/ui")
                .excludePathPatterns("/configuration/security")
        ;
    }

}
