package com.potter.elasticsearch.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.potter.elasticsearch.city.api")
public class SwaggerConfig extends WebMvcConfigurerAdapter{  
    @Bean  
    public Docket api(){  
        return new Docket(DocumentationType.SWAGGER_2)  
        		.apiInfo(buildApiInf())
                .select()                     
                .apis(RequestHandlerSelectors.basePackage("com.potter.elasticsearch.city.api"))   
                .paths(PathSelectors.any())            
                .build();  
    }  
    @Override//
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        registry.addResourceHandler("swagger-ui.html")  
                .addResourceLocations("classpath:/META-INF/resources/");  
        registry.addResourceHandler("webjars/**")  
                .addResourceLocations("classpath:/META-INF/resources/webjars/");  
    }  
    
    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("elasticsearch测试api接口")
                .version("1.0.0")
                .termsOfServiceUrl("#")
                .description("elasticsearch 城市api接口 ")
                .build();

    }
}  