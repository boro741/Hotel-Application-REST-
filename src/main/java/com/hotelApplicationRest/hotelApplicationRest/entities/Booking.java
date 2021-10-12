package com.hotelApplicationRest.hotelApplicationRest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Booking {
	
	@Id
	@Column(nullable = false,unique=true)	
	private String booking_id;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Room> rooms; 
		
	public Booking(BookingRequest req) {
		this.booking_id = req.getBooking_id();
	}
	
	public Booking() {
		super();

	}

	public Booking(String booking_id,List<Room> rooms) {
		this.booking_id = booking_id;
		this.rooms = rooms;
	}
	
	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}