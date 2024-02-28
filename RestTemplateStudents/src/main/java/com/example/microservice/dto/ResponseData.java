package com.example.microservice.dto;

import com.example.microservice.model.Student;
import com.example.microservice.model.Teacher;

public class ResponseData {

	private Student student;

	private Teacher teacher;

	public ResponseData() {
		super();
	}

	public ResponseData(Student student, Teacher teacher) {
		super();
		this.student = student;
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "ResultData [student=" + student + ", teacher=" + teacher + "]";
	}

}
