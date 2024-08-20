package com.nhung.cruddemo.dao;

import com.nhung.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentImpl implements StudentDAO{

    // define fields for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
