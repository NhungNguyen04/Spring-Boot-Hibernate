package com.nhung.mappingdemo.repository;

import com.nhung.mappingdemo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="courses")
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c from Course c where c.id = :id")
    public Course findByCourseId(@Param("id") Integer id);
}
