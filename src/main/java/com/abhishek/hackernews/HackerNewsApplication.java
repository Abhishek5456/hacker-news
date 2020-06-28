package com.abhishek.hackernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
public class HackerNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerNewsApplication.class, args);
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}
