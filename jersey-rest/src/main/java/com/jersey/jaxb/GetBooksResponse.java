package com.jersey.jaxb;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetBooksResponse {
	private Student student;
	private List<Book> books = new ArrayList<Book>();

	@XmlElement
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@XmlElement
	@XmlElementWrapper(name = "books")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}