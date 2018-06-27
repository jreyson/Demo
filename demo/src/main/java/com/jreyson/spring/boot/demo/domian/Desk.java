package com.jreyson.spring.boot.demo.domian;

/**
 * User 实体
 * @author Administrator
 *
 */
public class Desk {

	private long id;	//实体唯一标识
	private String color;
	private String size;
	private String status;
	private double price;
	private String office;
	
	public Desk() {
		
	}
	
	public Desk(long id, String color, String size, String status) {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	
	
}
