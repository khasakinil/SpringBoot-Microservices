package com.spring.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.course.CourseJDBC;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insertDataInCourse(new CourseJDBC(1, "MongoDB", "Udemy"));
		repository.insertDataInCourse(new CourseJDBC(2, "AWS", "Sunbeam"));
		repository.insertDataInCourse(new CourseJDBC(3, "GCP", "Seed Infotech"));
		repository.insertDataInCourse(new CourseJDBC(4, "Apache Spark", "Profound Infotech"));
		repository.deleteById(3);
		System.out.println(repository.findById(4));
	}

}
