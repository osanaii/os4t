package com.os4t;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class Os4tApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Os4tApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Os4tApplication.class);
	}
}
