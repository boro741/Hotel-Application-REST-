package com.hotelApplicationRest.hotelApplicationRest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	
	
	@Id
	@Column(nullable = false,unique=true)	
	private String room_no;
	@Column()
	private double price;
	@Column()
	private boolean available = false;
	
	
	public Room(String roomNo, double price, boolean available) {
		super();
		this.room_no = roomNo;
		this.price = price;
		this.available = available;
	}


	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getRoomNo() {
		return room_no;
	}


	public void setRoomNo(String roomNo) {
		room_no = roomNo;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	

	
}