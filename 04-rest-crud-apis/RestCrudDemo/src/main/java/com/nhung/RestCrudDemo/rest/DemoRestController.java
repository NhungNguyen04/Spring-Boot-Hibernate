package com.nhung.RestCrudDemo.rest;

import com.nhung.RestCrudDemo.DAO.StudentDAOImpl;
import com.nhung.RestCrudDemo.entity.Student;
import com.nhung.RestCrudDemo.errorresponse.StudentErrorResponse;
import com.nhung.RestCrudDemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private final StudentDAOImpl studentDAO;

    public DemoRestController(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello World";
//    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        List<Student> students = studentDAO.findAll();
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        List<Student> students = studentDAO.findAll();

        if(studentId > students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found for id " + studentId);
        }
        return students.get(studentId);
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
//
//        StudentErrorResponse error = new StudentErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                exception.getMessage(),
//                System.currentTimeMillis()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
}
