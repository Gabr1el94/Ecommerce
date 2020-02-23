package com.gabrielsoaresdev.ecommerce.Ecommerce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.gabrielsoaresdev.ecommerce.entity" })
@EnableJpaRepositories(basePackages = { "com.gabrielsoaresdev.ecommerce.repository" })
@ComponentScan(basePackages = {"com.gabrielsoaresdev.ecommerce.service","com.gabrielsoaresdev.ecommerce.controller"})
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
