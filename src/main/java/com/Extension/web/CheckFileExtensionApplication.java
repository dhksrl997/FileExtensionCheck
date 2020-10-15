package com.Extension.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CheckFileExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckFileExtensionApplication.class, args);
	}

}
