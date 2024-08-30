package com.nhung.RestCrudDemo.rest;

import com.nhung.RestCrudDemo.DAO.StudentDAOImpl;
import com.nhung.RestCrudDemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return students.get(studentId);
    }
}
