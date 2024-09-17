package com.nhung.mappingdemo.repository;

import com.nhung.mappingdemo.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(path="instructors")
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.instructorDetailId.id = :instructorDetailId")
    Instructor findByInstructorDetailId(@Param("instructorDetailId") Integer instructorDetailId);
}
