package util;

import dto.roomDTO;
import dto.userDTO;
import model.room;
import model.user;

public class valueMapper {

	public static user convertToUser(userDTO u1) {
		user u2 = new user(u1.getUserId(),u1.getUserName(),u1.getUserPassword(),u1.getUserPhone(),u1.getUserEmail(),u1.getUserRole(),u1.getUserFee(),u1.getUserRoom());
		return u2;
	}

	public static room convertToRoom(roomDTO r1) {
		room r2 = new room(r1.getRoomId(), r1.getRoomName(), r1.getRoomType());
		return r2;
	}
}
