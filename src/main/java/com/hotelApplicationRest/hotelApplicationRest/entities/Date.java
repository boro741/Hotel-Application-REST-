package com.hotelApplicationRest.hotelApplicationRest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Date {
	
	@Id
	@Column(nullable = false,unique=true)
	private String date;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Room> room; // 1 date can have any number of rooms for different users. ( One to Many )
	
	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date(String date, List<Room> room) {
		super();
		this.date = date;
		this.room = room;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}
	

	
	
}
