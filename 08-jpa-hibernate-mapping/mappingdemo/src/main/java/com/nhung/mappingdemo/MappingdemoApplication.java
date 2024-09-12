package com.nhung.mappingdemo;

import com.nhung.mappingdemo.Entity.Instructor;
import com.nhung.mappingdemo.Entity.InstructorDetail;
import com.nhung.mappingdemo.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}


}
