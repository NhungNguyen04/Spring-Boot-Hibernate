package com.nhung.restrealtime.repository;

import com.nhung.restrealtime.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="class12a1")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
