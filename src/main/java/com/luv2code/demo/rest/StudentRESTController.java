package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
		return students.get(studentID);
	}

}