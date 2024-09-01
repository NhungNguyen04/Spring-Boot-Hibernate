package com.nhung.restrealtime.repository;

import com.nhung.restrealtime.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
