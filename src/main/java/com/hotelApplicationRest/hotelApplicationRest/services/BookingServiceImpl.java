package com.hotelApplicationRest.hotelApplicationRest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelApplicationRest.hotelApplicationRest.dao.BookingDao;
import com.hotelApplicationRest.hotelApplicationRest.entities.Booking;
import com.hotelApplicationRest.hotelApplicationRest.entities.Date;
import com.hotelApplicationRest.hotelApplicationRest.entities.Room;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookingDao;

	@Override
	public void addBooking(Booking booking) {
		this.bookingDao.save(booking);
	}

	

}
