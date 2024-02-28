package com.example.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.dto.ResponseData;
import com.example.microservice.model.Student;
import com.example.microservice.model.Teacher;
import com.example.microservice.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	ResponseData response = new ResponseData();

	@GetMapping("get-all-student")
	@ResponseBody
	public ResponseEntity<List<ResponseData>> getAllStudent() {
		List<ResponseData> resultData=new ArrayList<>();
		List<Student> allStudent = studentService.getAllStudent();
		for(Student student:allStudent) {
			Teacher teacher = getTeacherById(student.getTeacherId());
			resultData.add(new ResponseData(student,teacher));
		}
		return new ResponseEntity<List<ResponseData>>(resultData,HttpStatus.OK);
	}
	
	private Teacher getTeacherById(long tId) {
		RestTemplate restTemplate = new RestTemplate();
		String endPoint = "http://localhost:8080/teacher/{tId}";
		ResponseEntity<Teacher> teacherData = restTemplate.getForEntity(endPoint, Teacher.class, tId);
        return teacherData.getBody();
    }

	@GetMapping("/{sId}")
	@ResponseBody
	public ResponseEntity<ResponseData> getStudentById(@PathVariable("sId") long sId) {
		Student studentData = studentService.getStudentById(sId);
		response.setStudent(studentData);
		long teacherId = studentData.getTeacherId();

		RestTemplate restTemplate = new RestTemplate();
		String endPoint = "http://localhost:8080/teacher/{teacherId}";
		ResponseEntity<Teacher> teacherData = restTemplate.getForEntity(endPoint, Teacher.class, teacherId);
		
		if (teacherData.getStatusCodeValue() == 200) {
			Teacher teacher = teacherData.getBody();
			response.setTeacher(teacher);
		}
		
		return new ResponseEntity<ResponseData>(response,HttpStatus.OK);
	}

}
