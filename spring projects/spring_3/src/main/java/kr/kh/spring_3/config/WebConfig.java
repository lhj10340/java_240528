package kr.kh.spring_3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.kh.spring_3.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
		
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor )
	                .addPathPatterns("/guest/login") 
	                .excludePathPatterns("위 경로 중 제외할 경로"); // 특정 경로 제외
    }

}
	
