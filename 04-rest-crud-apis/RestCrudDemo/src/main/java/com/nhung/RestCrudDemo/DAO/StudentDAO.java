package com.nhung.RestCrudDemo.DAO;

import com.nhung.RestCrudDemo.entity.Student;


import java.util.List;

public interface StudentDAO {

    void save(Student student);

    List<Student> findAll();
}
