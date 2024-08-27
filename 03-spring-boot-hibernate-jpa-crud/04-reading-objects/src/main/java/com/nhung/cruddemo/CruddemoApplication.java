package com.nhung.cruddemo;

import com.nhung.cruddemo.dao.StudentDAO;
import com.nhung.cruddemo.dao.StudentDAOImpl;
import com.nhung.cruddemo.entity.Student;
import jakarta.persistence.Index;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//			createStudent(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating student object ...");
		Student tempStudent = new Student("harrypotter@gmail.com", "Potter", "Harry");

		// save the student
		studentDAO.save(tempStudent);

		//  display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student, generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student object with id " + theId);
		Student foundStudent = studentDAO.findById(1);

		// display student
		System.out.println("Found the student " + foundStudent);
	}

}





