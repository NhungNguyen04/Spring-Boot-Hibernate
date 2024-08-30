package com.nhung.RestCrudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudDemoApplication.class, args);
	}

}
