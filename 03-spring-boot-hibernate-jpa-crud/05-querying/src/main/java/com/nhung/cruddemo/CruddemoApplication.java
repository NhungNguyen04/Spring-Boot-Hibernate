package com.nhung.cruddemo;

import com.nhung.cruddemo.dao.StudentDAO;
import com.nhung.cruddemo.dao.StudentDAOImpl;
import com.nhung.cruddemo.entity.Student;
import jakarta.persistence.Index;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private final StudentDAOImpl studentDAOImpl;

	public CruddemoApplication(StudentDAOImpl studentDAOImpl) {
		this.studentDAOImpl = studentDAOImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			queryStudent(studentDAO);
			queryStudentByLastName(studentDAO);
		};
	}

	private void queryStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Potter");
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}





