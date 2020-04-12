package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

@RestController
@RequestMapping(path = "/api", method = RequestMethod.GET)
public class StudentRESTController {

	private List<Student> students = new ArrayList<>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Amritesh", "Chandan"));
		students.add(new Student("Aman", "Raj"));
		students.add(new Student("Jayant", "Kumar"));
	}

	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public List<Student> getStudents() {
		return students;
	}
	
	@RequestMapping(path = "/students/{studentID}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable int studentID) {
		
		if (studentID >= students.size() || studentID < 0) {
			throw new StudentNotFoundException("Student ID " + studentID + " not found.");
		}
		
		return students.get(studentID);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(studentNotFoundException.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
		
	}

}