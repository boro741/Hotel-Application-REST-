package com.hotelApplicationRest.hotelApplicationRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelApplicationRest.hotelApplicationRest.entities.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking,String>{
	
}
