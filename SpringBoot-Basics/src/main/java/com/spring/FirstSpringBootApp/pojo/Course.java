package com.spring.FirstSpringBootApp.pojo;

public class Course {

	private long id;
	private String courseName;
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Course(long id, String courseName, String location) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", location=" + location + "]";
	}

}
