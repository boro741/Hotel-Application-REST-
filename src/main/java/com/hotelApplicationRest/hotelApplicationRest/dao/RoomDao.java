package com.hotelApplicationRest.hotelApplicationRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelApplicationRest.hotelApplicationRest.entities.Room;

public interface RoomDao extends JpaRepository<Room,String>{
	
}
