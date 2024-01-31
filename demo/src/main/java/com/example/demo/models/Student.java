package com.example.demo.models;

public class Student {
	private String studentName;
    private String city;
	private String course;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student(String studentName, String city, String course) {
		super();
		this.studentName = studentName;
		this.city = city;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + ", course=" + course + "]";
	}
	
	

}
