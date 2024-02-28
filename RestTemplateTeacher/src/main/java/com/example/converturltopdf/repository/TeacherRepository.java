package com.example.converturltopdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.converturltopdf.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
