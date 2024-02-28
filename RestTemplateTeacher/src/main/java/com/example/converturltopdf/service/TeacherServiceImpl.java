package com.example.converturltopdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.converturltopdf.model.Teacher;
import com.example.converturltopdf.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(long tId) {
		Teacher teacher = teacherRepository.findById(tId).get();
		return teacher;
	}

}
