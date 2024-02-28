package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
