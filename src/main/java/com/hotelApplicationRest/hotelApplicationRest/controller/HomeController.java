package com.hotelApplicationRest.hotelApplicationRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotelApplicationRest.hotelApplicationRest.entities.Room;
import com.hotelApplicationRest.hotelApplicationRest.services.RoomService;


@RestController
public class HomeController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/")
	public String Home() {
		return "Welcome to Hotel Booking application";
	}
	
	
	// User
//	@PostMapping("/user/add")
//	public void addUser(@RequestBody User user) {
//		// TODO
//	}
	
	
	// ADMIN Operations::
	//===================

	// 1. Add Rooms
	@PostMapping("/admin/rooms/add")
    @ResponseStatus(HttpStatus.CREATED)
	public void addRooms(@RequestBody List<Room> rooms) {
		this.roomService.addRooms(rooms);
	}
	
	// 2. Get All Rooms
	@GetMapping("/admin/rooms")
	public List<Room> getAllRooms(){
		
		return this.roomService.getAllRooms();
	}
	
	
	// 3. Remove Room by RoomNo
	@DeleteMapping("/admin/rooms/{roomNo}")
	public ResponseEntity<HttpStatus> removeRoom(@PathVariable String roomNo) {
		try {
			this.roomService.removeRoom(roomNo);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// 4. Update details by RoomNo
	@PutMapping("/admin/rooms")
	public ResponseEntity<HttpStatus> updateRooms(@RequestBody List<Room> rooms) {
		
		 try {
			 this.roomService.updateRooms(rooms);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}catch(Exception e){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

	
	// USER Operations:
	//==================
	
	
	// 1. Book a room by roomno
	
	// 2. Book random rooms on random days
	
	// 3. Book list of rooms on particular date
	
	// 4. Book room on list of dates
	
	// 5. View rooms in a hotel
	
	
	
	
}
