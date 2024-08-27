package com.nhung.cruddemo.dao;

import com.nhung.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
