package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.*;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.demo")
@EnableAspectJAutoProxy()
public class NewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewApplication.class, args);
	}


}

