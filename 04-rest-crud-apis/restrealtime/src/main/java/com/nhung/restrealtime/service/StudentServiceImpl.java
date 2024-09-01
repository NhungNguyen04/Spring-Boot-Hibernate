package com.nhung.restrealtime.service;

import com.nhung.restrealtime.DAO.StudentDAO;
import com.nhung.restrealtime.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentDAO.deleteStudentById(id);
    }
}
