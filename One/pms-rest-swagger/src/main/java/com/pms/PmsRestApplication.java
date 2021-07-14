package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class PmsRestApplication implements  WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PmsRestApplication.class, args);
	}
	
	
	  @Override
	  public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**").allowedOrigins("*").allowedMethods("*"); 
	  }
	  
	  @Bean
	  public  Docket   docket() {
		  ApiInfo  apiInfo = new ApiInfoBuilder().title("PMS REST DOCUMENTATION")
				  .description("Pms Rest CRUD operations").version("1.1")
				  .contact(new Contact("Shekher", null, "javashekher@gmail.com"))
				  .license("Sathya license").licenseUrl("http://www.sathyatech.com").build();
	  
		  return new Docket(DocumentationType.SWAGGER_2)
				  .select()
				  .apis(RequestHandlerSelectors.basePackage("com.pms.controller"))
				  .paths(PathSelectors.any())
				  .build().apiInfo(apiInfo)
				  .useDefaultResponseMessages(false);
	  }

}
