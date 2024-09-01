package com.nhung.restrealtime;

import com.nhung.restrealtime.DAO.StudentDAO;
import com.nhung.restrealtime.entity.Student;
import com.nhung.restrealtime.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

//    private StudentDAO studentDAO;
//
//    // quick and dirty: inject employee dao
//    public StudentRestController(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }
//
//    // expose "/students" and return a list of student
//    @GetMapping("/students")
//    public List<Student> getAllStudents() {
//        return studentDAO.getAllStudents();
//    }

//    -------------- Use Service: better -------------------------

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student theStudent = studentService.getStudentById(id);
        if (theStudent == null) {
            throw new RuntimeException("Student not found for id " + id);
        }
        return theStudent;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        theStudent.setId(0);
        Student dbStudent = studentService.saveStudent(theStudent);
        return dbStudent;
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student theStudent) {

        // handle exception if null
        theStudent.setId(id);
        Student dbStudent = studentService.saveStudent(theStudent);
        return dbStudent;
    }

    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable int id) {

        // handle exception if null
        studentService.deleteStudentById(id);
    }
}
