package com.movie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTicketBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingSystemApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	/*
	 * http://localhost:8080/swagger-ui/index.html#/
	 *  and the OpenAPI description
	 * will be available at the following url for json format:
	 * http://localhost:8080/v3/api-docs
	 */
	
	//try this method after the security
//	  @Bean
//	  public GroupedOpenApi publicApi() {
//	      return GroupedOpenApi.builder()
//	              .group("springshop-public")
//	              .pathsToMatch("/public/**")
//	              .build();
//	  }
//	  @Bean
//	  public GroupedOpenApi adminApi() {
//	      return GroupedOpenApi.builder()
//	              .group("springshop-admin")
//	              .pathsToMatch("/admin/**")
//	              .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
//	              .build();
//	  }
	


}
