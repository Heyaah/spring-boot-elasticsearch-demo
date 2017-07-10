package com.potter.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
public class ApplicationMain {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationMain.class, args);
	}
}
