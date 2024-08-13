package com.example.devtestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MydevtestappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MydevtestappApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MydevtestappApplication.class);
    }

}
