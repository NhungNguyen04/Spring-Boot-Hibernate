package com.nhung.restrealtime.service;

import com.nhung.restrealtime.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student saveStudent(Student student);

    void deleteStudentById(int id);
}
