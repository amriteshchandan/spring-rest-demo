package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

@RestController
@RequestMapping(path = "/api", method = RequestMethod.GET)
public class StudentRESTController {

	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Amritesh", "Chandan"));
		students.add(new Student("Aman", "Raj"));
		students.add(new Student("Jayant", "Kumar"));
		return students;
	}
	
}