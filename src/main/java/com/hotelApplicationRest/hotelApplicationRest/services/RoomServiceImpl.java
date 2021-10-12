package com.hotelApplicationRest.hotelApplicationRest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelApplicationRest.hotelApplicationRest.dao.RoomDao;
import com.hotelApplicationRest.hotelApplicationRest.entities.Room;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomDao roomDao;
	
	public RoomServiceImpl() {
	}
	
	@Override
	public void addRooms(List<Room> rooms) {
		
		for(Room room : rooms) {
			this.roomDao.save(room);
		}
		
	}
	
	@Override
	public List<Room> getAllRooms() {
		return this.roomDao.findAll();
	}

	
	@Override
	public void removeRoom(String roomNo) {
		Room entity = roomDao.getOne(roomNo);
		this.roomDao.delete(entity);
	}

	@Override
	public void updateRooms(List<Room> rooms) {
		for(Room room : rooms) {
			this.roomDao.save(room);
		}
	}

	@Override
	public Boolean isRoomAvailable(String roomNo) {
		List<Room> rooms = this.roomDao.findByAvailableTrue();
		
		for(Room room : rooms) {
			if(room.getRoom_no().equalsIgnoreCase(roomNo))
				return true;
		}
		
		return false;
	}

	@Override
	public Room getRoom(String roomNum) {
		return this.roomDao.getOne(roomNum);
	}

}
