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
//			queryStudentByLastName(studentDAO);
			updateLastName(studentDAO);
		};
	}

	private void updateLastName(StudentDAO studentDAO) {
		// find the object
		Student theStudent = studentDAO.findById(2);

		// call the setter method of the object
		theStudent.setLastName("Watson");

		// update the student
		studentDAO.update(theStudent);

		// display the updated student
		System.out.println("Updated student " + theStudent);
	}
}





