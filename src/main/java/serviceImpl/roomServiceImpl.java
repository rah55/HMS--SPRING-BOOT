//HERE WE IMPLEMENT ALL THE METHODS WE WRITE IN SERVICE CLASS

package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.roomDTO;
import exception.globalException;
import model.room;
import repository.roomRepository;
import service.roomService;
import util.valueMapper;

@Service
public class roomServiceImpl  implements roomService {
	@Autowired 	// THIS IS DEPENDENCY INJECTION
	private roomRepository roomrepo; 

	//HERE WE ADD ROOM 
	public room addRoom(roomDTO r1) {
		room r2 = valueMapper.convertToRoom(r1);
		return roomrepo.save(r2);
		}
	
	//HERE WE GET THE LIST OF THE ROOM 
	public List<room> getRoom(){
		
		return roomrepo.findAll();
	}
	
	//HERE WE UPDATE THE ROOM DETAILS
	public room updateRoom(roomDTO r1) {
		room r2=valueMapper.convertToRoom(r1);
				return roomrepo.save(r2);
	}
	
	//HERE WE DELETE THE ROOM
	public String deleteRoom(int roomid) throws globalException {
		room r2 =roomrepo.findByRoomId(roomid);
		if(r2!=null) {
			roomrepo.deleteById(roomid);
			return "deleted";
		}
		else {
			 throw new globalException("Room Not found");
		}
		
	}
}

