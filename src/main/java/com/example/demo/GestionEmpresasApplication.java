package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GestionEmpresasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEmpresasApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GestionEmpresasApplication.class);
	}

}
