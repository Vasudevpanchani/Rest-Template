package com.example.converturltopdf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.converturltopdf.model.Teacher;
import com.example.converturltopdf.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/get-all-teacher")
	@ResponseBody
	public ResponseEntity<List<Teacher>> getAllTeacher(){
		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeacher(),HttpStatus.OK);
	}
	
	@GetMapping("/{tId}")
	@ResponseBody
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("tId") long tId){
		return new ResponseEntity<Teacher>(teacherService.getTeacherById(tId),HttpStatus.OK);
	}

}
