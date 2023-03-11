package com.spring.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.course.CourseJPA;
import com.spring.course.jpa.CourseDataJpaRepository;

@Component
public class CourseDataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new CourseJPA(8, "Apache Tomcat", "Apache Foundation"));
		repository.save(new CourseJPA(9, "Advanced SpringBoot", "Udemy"));

		repository.findById(6);

		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println("find by author started");
		System.out.println(repository.findByAuthor("Apache Foundation"));
		System.out.println("find by author completed");
		
		System.out.println("find by name started");
		System.out.println(repository.findByName("Advanced SpringBoot"));
		System.out.println("find by name completed");
	}

}
