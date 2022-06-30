package com.jejupass.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jejupass.common.filter.HTMLCharacterEscapes;
import com.jejupass.common.interceptor.LoginCheckInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	Logger log = LoggerFactory.getLogger(WebConfig.class);

	@Value("${spring.webservice.intro}")
    private String introPage;
	
	// 실제 파일 저장
    @Value("${file.upload.path}")
    private String uploadPath;

    // URL 경로
    @Value("${file.upload.url}")
    private String uploadUrl;
    
	/*
	 * 로그인 인증 Interceptor 설정
	 */
	@Autowired
	LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 루트 (/) 로 접근 시 introPage 이동
        registry.addRedirectViewController("/", introPage);

    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**/*.do")
		        .excludePathPatterns("/index.do")
		        .excludePathPatterns("/user/*.do")
		        .excludePathPatterns("/comm/*.do")
				.excludePathPatterns("/error");
	}

	/**
	 * Message Converter
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(escapingConverter());
    }

	@SuppressWarnings("rawtypes")
	@Bean
	public HttpMessageConverter escapingConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

		MappingJackson2HttpMessageConverter escapingConverter = new MappingJackson2HttpMessageConverter();
		escapingConverter.setObjectMapper(objectMapper);
		return escapingConverter;
	}
	
}
