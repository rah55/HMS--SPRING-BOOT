package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.userDTO;
import exception.globalException;
import model.user;
import repository.userRepository;
import service.userService;
import util.valueMapper;

@Service
public class userServiceImpl implements userService {
	
	@Autowired        //THIS IS DEPENDENCY INJECTION
	private userRepository userrepo; 
	
	//HERE WE ADD THE USER
	public user addUser(userDTO u1) {  
	user u2=valueMapper.convertToUser(u1);
	return userrepo.save(u2);
	}
	
	//HERE WE GET THE LIST OF THE USER
	public List<user> getUser(){
		return userrepo.findAll();
	}
	
	//HERE WE UPDATE THE USER DETAILS
	public user updateUser(userDTO u1) {
		user u2 = valueMapper.convertToUser(u1);
		return userrepo.save(u2);
	}
	
	//HERE WE DELETE THE USER 
	public String deleteUser(int userid) throws globalException{
		 user u2 = userrepo.findByUserId(userid);
		 if(u2!=null) {
			 userrepo.deleteById(userid);
			 return "delete";
			 }
			 
			 else {
				 throw new globalException ("user not found");
			 }
		 
	}
	
	@Override
	public String updatePhone(int userid,String phone)throws globalException{  //HERE UPDATEPHONE METHOD IS IMPLEMENTED
		int st = userrepo.updatePhone(userid,phone);
		if(st==1) {    // IF USERID IS FOUND THEN IT WILL UPDATE THE NUMBER
			return "updated...";
		}
		else {    	// IF USERID NOT FOUND 
			throw new globalException("something went wrong ");
		}
	}
	
	@Override
	public String allotRoom(int userid,int roomid) throws globalException {   // HERE WE ALLOT THE ROOM THE GIVEN USER
		int st=userrepo.allotRoom(userid,roomid);
		if(st==1) {									// IF USER ID IS FOUND THEN ROOM WILL ALLOT 
			return "Room alloted to " +userid;
		}
		else {										// IF USER ID IS NOT FOUND
			throw new globalException("something went wrong");
			}
	}
}
