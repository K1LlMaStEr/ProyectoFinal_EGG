package com.grupoD.offiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sources.servicios")
public class OffiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffiappApplication.class, args);
	}

}
