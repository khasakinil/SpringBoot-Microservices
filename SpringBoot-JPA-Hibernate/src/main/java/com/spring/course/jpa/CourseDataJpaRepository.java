package com.spring.course.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.course.CourseJPA;

@Transactional
@Repository
public interface CourseDataJpaRepository extends JpaRepository<CourseJPA, Integer> {

	public List<CourseJPA> findByAuthor(String authorName);

	public List<CourseJPA> findByName(String string);

}
