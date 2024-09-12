package com.nhung.mappingdemo.repository;


import com.nhung.mappingdemo.Entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="instructor-details")
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

}
