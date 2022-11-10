package com.hmsSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //THIS NOTATION ENABLE THE SWAGGER
public class HmsWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsWithSpringApplication.class, args);
	}

}
