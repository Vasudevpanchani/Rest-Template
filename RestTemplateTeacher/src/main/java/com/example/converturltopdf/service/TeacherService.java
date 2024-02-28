package com.example.converturltopdf.service;

import java.util.List;

import com.example.converturltopdf.model.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeacher();
	
	Teacher getTeacherById(long tId);

}
