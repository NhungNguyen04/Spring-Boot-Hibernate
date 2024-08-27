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
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new  student object ...");
		Student tempStudent = new Student("nhung@gmail.com", "Nguyen", "Nhung");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student generated id: " + tempStudent.getId());

		// create the student object
		System.out.println("Creating new  student object ...");
		Student tempStudent1 = new Student("nhan@gmail.com", "Cao", "Nhan");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);

		// display id of the saved student
		System.out.println("Saved student generated id: " + tempStudent.getId());

		// create the student object
		System.out.println("Creating new  student object ...");
		Student tempStudent2 = new Student("phuong@gmail.com", "Nguyen", "Phuong");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent2);

		// display id of the saved student
		System.out.println("Saved student generated id: " + tempStudent.getId());
	}

}





