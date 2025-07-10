package com.pbkan.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer{

	private String mapping = "/boardUploadPdf/**";
	private String location	= "file:///C:/PDF_tight/upload/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(mapping)
			.addResourceLocations(location);
	}
}
