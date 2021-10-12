package com.hotelApplicationRest.hotelApplicationRest.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Room {
	
	
	@Id
	@Column(nullable = false,unique=true)	
	private String room_no;
	@Column()
	private double price;
	@Column()
	private boolean available = true;
	@Column()
	private String userName;
	

	@JoinColumn(name="booking_date")
	@ManyToOne(cascade = {CascadeType.ALL})
	private Date date; // One room can have only 1 date
	


	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getRoom_no() {
		return room_no;
	}


	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}