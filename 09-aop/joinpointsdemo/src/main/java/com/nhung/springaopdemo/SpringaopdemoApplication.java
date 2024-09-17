package com.nhung.springaopdemo;

import com.nhung.springaopdemo.dao.AccountDAO;
import com.nhung.springaopdemo.dao.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringaopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, Member theMember) {
		return args -> {
			demoBeforeAdvice(theAccountDAO, theMember);
		};
	}

	public void demoBeforeAdvice(AccountDAO theAccountDAO, Member member) {
		theAccountDAO.setName("Nhung");
		member.setId(1);

		System.out.println(theAccountDAO.getName());
		System.out.println(member.getId());

		theAccountDAO.sendToCloud();
		member.sendApi();
	}

}
