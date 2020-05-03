package com.ganesh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@EnableWebFlux
public class ApiConfig {
    
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMappers = new ObjectMapper();
		objectMappers.registerModule(new JavaTimeModule());
		objectMappers.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		
		return objectMappers;
	}
	
	@Bean
	public ObjectWriter objectWriter(ObjectMapper objectMapper) {
		return objectMapper.writerWithDefaultPrettyPrinter();
	}
}
