package com.nhung.springaopdemo;

import com.nhung.springaopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringaopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
		return args -> {
			demoBeforeAdvice(theAccountDAO);
		};
	}

	public void demoBeforeAdvice(AccountDAO theAccountDAO) {
		theAccountDAO.addAccount();
	}

}
