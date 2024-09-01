package com.nhung.restrealtime.DAO;

import com.nhung.restrealtime.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student saveStudent(Student student);

    void deleteStudentById(int id);
}
