package com.spring.FirstSpringBootApp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.FirstSpringBootApp.pojo.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

	@RequestMapping("/getall")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(new Course(1, "Java", "Pune"), new Course(2, "AWS", "Pune"),  new Course(3, "Docker", "Hyderabad"));
	}

}
