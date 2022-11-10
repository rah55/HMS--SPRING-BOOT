//HERE WE WRITE ALL THE REST APIs
package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.roomDTO;
import exception.globalException;
import model.room;
import serviceImpl.roomServiceImpl;

@RestController     //THIS ANNOTATION USED FOR CREATING APIs
@RequestMapping("/room")
public class roomController {
	@Autowired       // DEPENDENCY INJECTION
	private roomServiceImpl service;

	@GetMapping("/get")          // API FOR GETTING THE LIST OF THE ROOMS
	public ResponseEntity<List<room>>getRooms(){
		return new ResponseEntity<>(service.getRoom(),HttpStatus.OK);
	}
	
	@PostMapping("/add")        // API FOR ADDING THE ROOM
	public ResponseEntity<room> addRoom(@RequestBody @Valid roomDTO r1){
		return new ResponseEntity<>(service.addRoom(r1),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")         // API FOR UPDATE THE VALUE IN ROOMS
	public ResponseEntity<room> updateRoom(@RequestBody @Valid roomDTO r1){
		return new ResponseEntity<>(service.updateRoom( r1),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{roomid}")		// API FOR DELETING THE ROOM
	public ResponseEntity<String> deleteRoom(@PathVariable int roomid)throws globalException{
		
		String st = service.deleteRoom(roomid);
		if(st!=null) {
			return new ResponseEntity<>(st,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>(st,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

