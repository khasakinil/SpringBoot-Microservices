package com.spring.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.course.CourseJPA;
import com.spring.course.jpa.CourseJpaRepository;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new CourseJPA(6, "Apache Kafka", "Apache Foundation"));
		repository.insert(new CourseJPA(7, "Apache Flink", "Apache Foundation"));
		
		repository.findById(6);
	}

}
