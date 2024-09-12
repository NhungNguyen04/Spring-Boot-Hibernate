package com.nhung.mappingdemo.repository;

import com.nhung.mappingdemo.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="instructors")
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
