package com.hotelApplicationRest.hotelApplicationRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelApplicationRest.hotelApplicationRest.entities.Room;

@Repository
public interface RoomDao extends JpaRepository<Room,String>{
	// Returns available or unvailable rooms
	public List<Room> findByAvailableTrue();
}
