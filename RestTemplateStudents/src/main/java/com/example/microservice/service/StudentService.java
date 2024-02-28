package com.example.microservice.service;

import java.util.List;

import com.example.microservice.model.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	
	Student getStudentById(long sId);

}
