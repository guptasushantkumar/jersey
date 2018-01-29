package com.jersey.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "students")
public class Student {
	private long rollNumber;
	private String name;
	private String course;

	@XmlElement(name = "rollNumber")
	public long getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "course")
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
