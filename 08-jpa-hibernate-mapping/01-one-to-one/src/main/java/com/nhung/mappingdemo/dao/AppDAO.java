package com.nhung.mappingdemo.dao;

import com.nhung.mappingdemo.Entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);
}
