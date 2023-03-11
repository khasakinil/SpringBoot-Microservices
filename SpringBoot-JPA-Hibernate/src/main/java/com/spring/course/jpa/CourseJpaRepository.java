package com.spring.course.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.course.CourseJPA;

@Transactional
@Repository
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(CourseJPA course) {
		entityManager.merge(course);
	}

	public void findById(int id) {
		entityManager.find(CourseJPA.class, id);
	}

	public void deleteById(int id) {
		CourseJPA course = entityManager.find(CourseJPA.class, id);
		entityManager.remove(course);
	}
}
