package com.hotelApplicationRest.hotelApplicationRest.services;

import java.util.List;

import com.hotelApplicationRest.hotelApplicationRest.entities.Room;

public interface RoomService {
	public List<Room> getAllRooms();
	public void addRooms(List<Room> rooms);
	public void removeRoom(String roomNo);
	public void updateRooms(List<Room> rooms);
	public Boolean isRoomAvailable(String roomNo);
	public Room getRoom(String roomNum);
}
