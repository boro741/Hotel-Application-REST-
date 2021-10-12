package com.hotelApplicationRest.hotelApplicationRest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotelApplicationRest.hotelApplicationRest.entities.Booking;
import com.hotelApplicationRest.hotelApplicationRest.entities.BookingRequest;
import com.hotelApplicationRest.hotelApplicationRest.entities.Date;
import com.hotelApplicationRest.hotelApplicationRest.entities.Room;
import com.hotelApplicationRest.hotelApplicationRest.services.BookingService;
import com.hotelApplicationRest.hotelApplicationRest.services.DateService;
import com.hotelApplicationRest.hotelApplicationRest.services.RoomService;


@RestController
public class HomeController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private DateService dateService;
	@Autowired
	private BookingService bookingService;
	
	
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
	public ResponseEntity<HttpStatus> addRooms(@RequestBody List<Room> rooms) {
		this.roomService.addRooms(rooms);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	// 2. Get All Rooms
	@GetMapping("/admin/rooms")
	public ResponseEntity<List<Room>> getAllRooms(){
		return new ResponseEntity<List<Room>>(roomService.getAllRooms(),HttpStatus.OK);
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

	
	// test Date
	// Book a list of rooms on given date
	@PostMapping("/rooms/book")
	@ResponseStatus(HttpStatus.CREATED)
	public void addDate(@RequestParam("date") String date,@RequestBody BookingRequest req) {
		List<Room> rooms = new ArrayList<>();
		for(int i=0;i<req.getRoomNos().size();i++) {
			String roomNum = req.getRoomNos().get(i);
			String userName = req.getUserNames().get(i);
			if(roomService.isRoomAvailable(roomNum)) {
				Room room = roomService.getRoom(roomNum);
				Date toSetDate = new Date();
				this.dateService.addDate(date);
				room.setUserName(userName);
				room.setDate(toSetDate);
				rooms.add(room);
			}
		}
		
		
		
		Random rand = new Random();
		String bookingId = "15S11A"+rand.nextInt(1000);
		Booking booking = new Booking(bookingId,rooms);
		
		this.bookingService.addBooking(booking);
	}
	
	// USER Operations:
	//==================
	
	
	// 1. Book a room by roomno
	
	// 2. Book random rooms on random days
	
	// 3. Book list of rooms on particular date
	
	// 4. Book room on list of dates
	
	// 5. View rooms in a hotel
	
	
	
	
}
