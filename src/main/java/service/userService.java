package service;

import java.util.List;

import dto.userDTO;
import exception.globalException;
import model.user;

public interface userService {

	public user addUser(userDTO u1); //THIS IS FOR ADDING THE USER IN TABLE
	public List<user> getUser();  // THIS IS FOR GETTING THE LIST OF THE USER
	public user updateUser(userDTO u1); // THIS FOR UPDATING THE DETAILS IN THE EXSISTING USER
	public String deleteUser(int userid) throws globalException; // THIS IS FOR DELETE THE USER FROM THE TABLE
	public String updatePhone(int userid,String phone)throws globalException;	//THIS THE METHOD INTERFACE FOR UPDATING THE PHONE NUMBER
	public String allotRoom(int userid,int roomid)throws globalException;		// THIS IS THE METHOD INTERFACE FOR ALLOT THE ROOM TO THE USER
	public String updateFee(int userid,int userfee)throws globalException;
	
}
