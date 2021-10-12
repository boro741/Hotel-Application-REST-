package com.hotelApplicationRest.hotelApplicationRest.entities;

import java.util.List;


public class BookingRequest {

	private String booking_id;
	private List<String> dates;
	private List<String> roomNos;
	private List<String> userNames;
	
	
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<String> getDates() {
		return dates;
	}


	public void setDates(List<String> dates) {
		this.dates = dates;
	}


	public List<String> getRoomNos() {
		return roomNos;
	}


	public void setRoomNos(List<String> roomNo) {
		this.roomNos = roomNo;
	}


	public List<String> getUserNames() {
		return userNames;
	}


	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}


	public String getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}


		
}