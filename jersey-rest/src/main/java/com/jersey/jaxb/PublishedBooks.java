package com.jersey.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "bookId", "description", "quantity", "unitPrice",
		"subTotal", "tax", "total" })
public class PublishedBooks {

	private long bookId;
	private String description;
	private short quantity;
	private double unitPrice;

	@XmlElement
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	@XmlElement
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@XmlElement
	public double getSubTotal() {
		return unitPrice * quantity;
	}

	@XmlElement
	public double getTax() {
		return getSubTotal() * 0.15F;
	}

	@XmlElement
	public double getTotal() {
		return getSubTotal() + getTax();
	}
}