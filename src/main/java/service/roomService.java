// THIS IS USED FOR METHOD WE USE IN THE PROJECT
package service;

import java.util.List;

import dto.roomDTO;
import exception.globalException;
import model.room;

public interface roomService {
	
	public room addRoom(roomDTO r1);   // THIS IS FOR ADDING THE ROOM
	public List<room> getRoom();		// THIS IS FOR GET THE LIST OF THE ROOM 
	public room updateRoom(roomDTO r1);  // THIS IS THE FOR UPDATE THE DETAILS IN THE EXISTING ROOM
	public String deleteRoom(int roomid) throws globalException;	// THIS IS USED FOR DELETE THE ROOM FROM THE TABLE

}
