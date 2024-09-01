package com.nhung.restrealtime.DAO;

import com.nhung.restrealtime.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Student saveStudent(Student student) {

        // save student, if id==0, add new, otherwise update
        Student dbStudent = entityManager.merge(student);

        // return the dbStudent
        return dbStudent;
    }

    @Override
    public void deleteStudentById(int id) {

        // find student by id
        Student student = getStudentById(id);
        // delete student
        entityManager.remove(student);
    }
}
