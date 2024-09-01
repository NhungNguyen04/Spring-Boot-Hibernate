package com.nhung.restrealtime.service;

import com.nhung.restrealtime.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(int id);

    Student saveStudent(Student student);

    void deleteStudentById(int id);
}
