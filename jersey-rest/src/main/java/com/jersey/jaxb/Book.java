package com.jersey.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "publishDate", "publishNumber", "publishedBooks",
		"bookName" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@XmlElement
	public Date publishDate;

	@XmlElement
	public long publishNumber;

	@XmlElement
	public String bookName;

	@XmlElement
	@XmlElementWrapper(name = "publishedBooks")
	public PublishedBooks[] publishedBooks;

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public long getPublishNumber() {
		return publishNumber;
	}

	public void setPublishNumber(long publishNumber) {
		this.publishNumber = publishNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public PublishedBooks[] getPublishedBooks() {
		return publishedBooks;
	}

	public void setPublishedBooks(PublishedBooks[] publishedBooks) {
		this.publishedBooks = publishedBooks;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}