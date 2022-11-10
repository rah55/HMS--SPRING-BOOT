package repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.user;

public interface userRepository extends JpaRepository<user, Integer> {
	
	@Transactional
	@Modifying // THIS NOTATION IS USED FOR ANY TYPE OF UPDATION IN THE DATABASE
	@Query(value="update user set user_phone=:userphone where user_id=:userid") //HERE WE RUN A QUERY FOR UPDATING PHONE NUMBER IN DATABASE
	int updatePhone(int userid,String userphone);
	

	@Transactional 
	@Modifying
	@Query(value="update user set user_fee=:userFee where user_id=:userid")
	int updateFee(int userid,int userFee);
	
	
	@Transactional
	@Modifying 	//THIS NOTAION IS USED FOR ANY TYPE OF UPDATION IN THE DATABASE
	@Query(value="update user set user_room_room_id=:roomid where user_id=:userid") //HERE WE RUN A QUERY FOR ALLOT THE ROOM TO THE USER 
	int allotRoom(int userid ,int roomid);
	
	
	@Query(value = "selecct * from user where user_id=?1", nativeQuery = true) // HERE WE FIND THE DETAIL OF THE USER BY USERID
	user findByUserId(int userid);
	
	@Query(value="select * from user where user_name=?1",nativeQuery=true)
	user findByUserName(String username);
	
	
}
